import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import model.laporan;

public class LaporanPembelian {
    @FXML
    private ImageView back;

    @FXML
    private Button btnLogOut;

    @FXML
    private TableColumn<laporan, String> tcNamaBahan;

    @FXML
    private TableColumn<laporan, Integer> tcHargaSatuan;

    @FXML
    private TableColumn<laporan, Integer> tcQty;

    @FXML
    private TableColumn<laporan, Integer> tcTotal;

    @FXML
    private TableView<laporan> tvLaporanPembelian;

    LinkedList<laporan> linkedList = new LinkedList<>();
    Connection con = connection.kofiloConnection();

    @FXML
    public void initialize() {
        tcNamaBahan.setCellValueFactory(new PropertyValueFactory<>("NamaBahan"));
        tcQty.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        tcHargaSatuan.setCellValueFactory(new PropertyValueFactory<>("HargaBeli"));
        tcTotal.setCellValueFactory(new PropertyValueFactory<>("TotalHargaBeli"));

        try {
            Statement st = con.createStatement();
            String sql = "SELECT namabahan.NamaBahan, pembelian.Quantity, namabahan.HargaBeli, pembelian.TotalHargaBeli FROM pembelian, namabahan WHERE namabahan.NamaBahanID=pembelian.NamaBahanID";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                laporan tvLaporanPembelian = new laporan(rs.getString("NamaBahan"), (rs.getInt("Quantity")), (rs.getInt("HargaBeli")), (rs.getInt("TotalHargaBeli")));
                linkedList.add(tvLaporanPembelian);
            }
            tvLaporanPembelian.getItems().clear();
            tvLaporanPembelian.getItems().addAll(linkedList);

        } catch (Exception e) {
            e.getStackTrace();
            e.getCause();
        }
    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnLogOut(ActionEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    

}