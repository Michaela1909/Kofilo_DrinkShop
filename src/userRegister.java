import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class userRegister {

    @FXML
    private ImageView back;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private TextField email;

    @FXML
    private TextField fullName;

    @FXML
    private Label label;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phone;

    @FXML
    private Button register;

    @FXML
    private TextField username;

    Connection con = connection.kofiloConnection(); 
    PreparedStatement pst; 

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void register(ActionEvent event) throws IOException {
        try {
            pst = con.prepareStatement("INSERT INTO User(Username, FullName, Email, Phone, Password, RePassword, UserStatus) VALUES (?, ?, ?, ?, ?, ?, 'N')");
            pst.setString(1, username.getText());
            pst.setString(2, fullName.getText());
            pst.setString(3, email.getText());
            pst.setString(4, phone.getText());
            pst.setString(5, password.getText());
            pst.setString(6, confirmPassword.getText());

            if (username.getText().isEmpty()||fullName.getText().isEmpty()||email.getText().isEmpty()||phone.getText().isEmpty()||password.getText().isEmpty()||confirmPassword.getText().isEmpty()) {
                label.setText("Please fill out all requiered fields!");
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Textfield Kosong");
                alert.setContentText("Input Textfield!");
                alert.showAndWait();
            }

            while (password.getText().equals(confirmPassword.getText())) {
                int status = pst.executeUpdate();

                if (status == -1) {
                    JOptionPane.showMessageDialog(null, "record failed");
                } else {
                    username.setText(null);
                    fullName.setText(null);
                    email.setText(null);
                    phone.setText(null);
                    password.setText(null);
                    confirmPassword.setText(null);

                    Stage stage = (Stage) back.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("userLogin.fxml"));
                    stage.setTitle("Kofilo");
                    stage.setScene(new Scene(root));
                }
            }
            label.setText("password invalid");
            username.setText(null);
            fullName.setText(null);
            email.setText(null);
            phone.setText(null);
            password.setText(null);
            confirmPassword.setText(null);
        } catch (Exception e) {
            e.getStackTrace();
            e.getCause();
        }
    }
}