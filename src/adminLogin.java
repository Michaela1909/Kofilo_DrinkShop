import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

public class adminLogin {

    @FXML
    private ImageView back;

    @FXML
    private Label label;

    @FXML
    private Button login;

    @FXML
    private Label newAdmin;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    Connection con = connection.kofiloConnection();
    
    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void login(MouseEvent event) throws IOException {
        try {
            
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Username dan password kosong");
                alert.setContentText("Input username dan password!");
                alert.showAndWait();
            } else {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM user WHERE Username = '" + username.getText() + "'AND Password = '" + password.getText()+"'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    String status = rs.getString("UserStatus");
                    if (status.equals("A")) {
                        Stage stage = (Stage) login.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                        stage.setTitle("Kofilo");
                        stage.setScene(new Scene(root));
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Anda bukan admin");
                        alert.setContentText("Silahkan coba lagi!");
                        alert.showAndWait();
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

    @FXML
    void newAdmin(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("adminRegister.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

}