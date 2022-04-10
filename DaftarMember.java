import java.io.IOException;
import java.sql.Connection;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DaftarMember {

    @FXML
    private ImageView back;
    
    @FXML
    private Button btnKirim;

    @FXML
    private Button btnLogOut;

    @FXML
    private TextField tfNM;

    @FXML
    private TextField tfNoTelp;

    @FXML
    private TextField tfPW;

    @FXML
    private TextField tfUsername;

    Connection con = connection.kofiloConnection();
    
    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnKirim(ActionEvent event) {
        try {
            if (tfNM.getText().isEmpty() || tfNoTelp.getText().isEmpty() || tfUsername.getText().isEmpty() || tfPW.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Textfield is blank");
                alert.setContentText("Please fill all the required field!");
                alert.showAndWait();
            } else {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM user WHERE Username = '" + tfUsername.getText() + "'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    String status = rs.getString("UserStatus");

                    if (status.equals("N")) {

                        sql = "UPDATE user SET UserStatus='M' WHERE Username='" + tfUsername.getText() + "'";
                        st.executeUpdate(sql);

                        // buat dialog berhasil
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Berhasil");
                        alert.setHeaderText(null);
                        alert.setContentText("Daftar Member Baru Berhasil!");
                        alert.showAndWait();
                        
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Anda bukan belum terdaftar sebagai user");
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
                tfNM.setText("");
                tfNoTelp.setText("");
                tfPW.setText("");
                tfUsername.setText("");
            }
        } catch (Exception e) {
            e.getStackTrace();
            e.getCause();
        }
    }
                   
    @FXML
    void btnLogOut(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void tfNM(ActionEvent event) {

    }

    @FXML
    void tfNoTelp(ActionEvent event) {

    }

    @FXML
    void tfPW(ActionEvent event) {

    }

    @FXML
    void tfUsername(ActionEvent event) {

    }

}
