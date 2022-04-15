import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.ResultSet;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class userLogin {

    @FXML
    private ImageView back;

    @FXML
    private Label label;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    PreparedStatement pst; 

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }
    
    @FXML
    void login(ActionEvent event) throws IOException {
        try {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Username dan password kosong");
                alert.setContentText("Input username dan password!");
                alert.showAndWait();
            } else {
                Connection con = connection.kofiloConnection();
                Statement st = con.createStatement();
                String sql = "SELECT * FROM user WHERE Username = '" + username.getText() + "'AND Password = '" + password.getText()+"'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    String status = rs.getString("UserStatus");
                    if (status.equals("N") || status.equals("M")) {

                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
                        LocalDateTime now = LocalDateTime.now();  
                        
                        pst = con.prepareStatement("insert into Transaksi(TanggalTransaksi, UserID, Total) VALUES (?, (SELECT UserID FROM User WHERE Username = ?), 0)");
                        pst.setString(1, dtf.format(now));
                        pst.setString(2, username.getText());
                        pst.execute();

                        Stage stage = (Stage) login.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("userProduct.fxml"));
                        stage.setTitle("Kofilo");
                        stage.setScene(new Scene(root));
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Anda belum terdaftar sebagai user");
                        alert.setContentText("Silahkan coba lagi atau daftar user!");
                        alert.showAndWait();
                        username.setText(null);
                        password.setText(null);
                    }
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Terjadi kesalahan");
                    alert.setContentText("Silahkan coba lagi!");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
            e.getCause();
        }
    }
}