import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class firstPage {

    @FXML
    private Label admin;

    @FXML
    private Text contactUs;

    @FXML
    private Button login;

    @FXML
    private Button register;

    @FXML
    void admin(MouseEvent event) throws IOException {
        Stage stage = (Stage) admin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        Stage stage = (Stage) login.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("userLogin.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void register(ActionEvent event) throws IOException {
        Stage stage = (Stage) register.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("userRegister.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

}
