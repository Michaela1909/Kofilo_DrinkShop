import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.bahan;

public class Inventaris {

    @FXML
    private ImageView back;

    @FXML
    private Button btnLogOut;

    @FXML
    private TableColumn<bahan, Integer> tcHB;

    @FXML
    private TableView<bahan> tvInventaris;

    @FXML
    private TableColumn<bahan, String> tcNP;

    @FXML
    private TableColumn<bahan, Integer> tcQty;
    
    LinkedList<bahan> linkedList = new LinkedList<>();
    Connection con = connection.kofiloConnection();

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnLogOut(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }
    
    @FXML
    public void initialize() {
        tcNP.setCellValueFactory(new PropertyValueFactory<>("NamaBahan"));
        tcQty.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        tcHB.setCellValueFactory(new PropertyValueFactory<>("HargaBeli"));

        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM NamaBahan";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                bahan tvInventaris = new bahan(rs.getString("NamaBahan"), (rs.getInt("Quantity")), (rs.getInt("HargaBeli")));
                linkedList.add(tvInventaris);
            }
            tvInventaris.getItems().clear();
            tvInventaris.getItems().addAll(linkedList);

        } catch (Exception e) {
            e.getStackTrace();
            e.getCause();
        }
    }
}