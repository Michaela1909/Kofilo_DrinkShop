import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.order;

public class AfterUserProduct implements Initializable{

    @FXML
    private Button btnBack;

    @FXML
    private Button btnChekout;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private ComboBox<Integer> cbQuantity;

    @FXML
    private Label labelNamaItem;

    @FXML
    private TableColumn<order, Integer> tcHarga;

    @FXML
    private TableColumn<order, String> tcItem;

    @FXML
    private TableColumn<order, Integer> tcQuantity;

    @FXML
    private TableView<order> tvPesananSaya;

    Connection con = connection.kofiloConnection();
    LinkedList<order> ll = new LinkedList<>();

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnChekout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("userProduct.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void checkout(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnChekout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("userCheckout.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void delete(ActionEvent event) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE NamaBahan, Bahan, DetailOrder, Minuman SET NamaBahan.Quantity = NamaBahan.Quantity + (Bahan.Quantity * DetailOrder.Quantity) WHERE DetailOrder.MinumanID = Bahan.MinumanID AND bahan.NamaBahanID = NamaBahan.NamaBahanID AND DetailOrder.TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND Minuman.NamaMinuman = ?");
            pst.setString(1, labelNamaItem.getText());
            int status = pst.executeUpdate();
            if(status !=-1){
                pst = con.prepareStatement("DELETE FROM DetailOrder WHERE MinumanID = (SELECT MinumanID FROM Minuman WHERE NamaMinuman = ?) AND TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)");
                pst.setString(1, labelNamaItem.getText());
                int stats = pst.executeUpdate();
                if(stats !=-1){
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Berhasil");
                    alert.setHeaderText("Anda Berhasil Menghapus Item Anda!");
                    alert.setContentText("Terima Kasih.");
                    alert.showAndWait();
                    ll.clear();
                    try {
                        tvPesananSaya.getItems().clear();
                        Statement st = con.createStatement();
                        String sql = "SELECT Minuman.NamaMinuman, DetailOrder.Quantity, DetailOrder.Total FROM Minuman, DetailOrder WHERE Minuman.MinumanID = DetailOrder.MinumanID AND TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)";
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
                            order tvPesananSaya = new order(rs.getString("NamaMinuman"), (rs.getInt("Quantity")), (rs.getInt("Total")));
                            ll.add(tvPesananSaya);
                        }
                        tvPesananSaya.getItems().clear();
                        tvPesananSaya.getItems().addAll(ll);
                        labelNamaItem.setText(null);
                        cbQuantity.getItems().clear();
                    } catch (Exception e) {
                        //TODO: handle exception
                        e.printStackTrace();
                        e.getCause();
                    }
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    @FXML
    void edit(ActionEvent event) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE NamaBahan, Bahan, DetailOrder, Minuman SET NamaBahan.Quantity = NamaBahan.Quantity + (Bahan.Quantity * DetailOrder.Quantity) WHERE DetailOrder.MinumanID = Bahan.MinumanID AND bahan.NamaBahanID = NamaBahan.NamaBahanID AND DetailOrder.TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND Minuman.NamaMinuman = ?");
            pst.setString(1, labelNamaItem.getText());
            int stats = pst.executeUpdate();
            if(stats != -1){
                pst = con.prepareStatement("UPDATE DetailOrder SET DetailOrder.Quantity = ? WHERE MinumanID = (SELECT MinumanID FROM Minuman WHERE NamaMinuman = ?)");
                pst.setInt(1, cbQuantity.getSelectionModel().getSelectedItem());
                pst.setString(2, labelNamaItem.getText());
                int status = pst.executeUpdate();
                if(status !=-1){
                    pst = con.prepareStatement("UPDATE DetailOrder, Minuman SET DetailOrder.Total = DetailOrder.Quantity * Minuman.Harga WHERE DetailOrder.MinumanID = Minuman.MinumanID");
                    int statusUpdate = pst.executeUpdate();
                    if(statusUpdate!=-1){
                        pst = con.prepareStatement("UPDATE NamaBahan, Bahan, DetailOrder, Minuman SET NamaBahan.Quantity = NamaBahan.Quantity - (Bahan.Quantity * DetailOrder.Quantity) WHERE DetailOrder.MinumanID = Bahan.MinumanID AND bahan.NamaBahanID = NamaBahan.NamaBahanID AND DetailOrder.TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND Minuman.NamaMinuman = ?");
                        pst.setString(1, labelNamaItem.getText());
                        pst.executeUpdate();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Berhasil");
                        alert.setHeaderText("Anda Berhasil Mengubah Item Anda!");
                        alert.setContentText("Terima Kasih.");
                        alert.showAndWait();
                        ll.clear();
                        try {
                            tvPesananSaya.getItems().clear();
                            Statement st = con.createStatement();
                            String sql = "SELECT Minuman.NamaMinuman, DetailOrder.Quantity, DetailOrder.Total FROM Minuman, DetailOrder WHERE Minuman.MinumanID = DetailOrder.MinumanID AND TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)";
                            ResultSet rs = st.executeQuery(sql);
                            while (rs.next()) {
                                order tvPesananSaya = new order(rs.getString("NamaMinuman"), (rs.getInt("Quantity")), (rs.getInt("Total")));
                                ll.add(tvPesananSaya);
                            }
                            tvPesananSaya.getItems().clear();
                            tvPesananSaya.getItems().addAll(ll);
                            labelNamaItem.setText(null);
                            cbQuantity.getItems().clear();
                        } catch (Exception e) {
                            //TODO: handle exception
                            e.printStackTrace();
                            e.getCause();
                        }
                    }
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
        
    }
    
    @FXML
    void getSelected(MouseEvent event) {
        int index = tvPesananSaya.getSelectionModel().getSelectedIndex();
        if(index <=-1){
            return;
        }
        labelNamaItem.setText(tcItem.getCellData(index).toString());
        cbQuantity.setValue(tcQuantity.getCellData(index));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
        cbQuantity.setItems(list);
        
        tcItem.setCellValueFactory(new PropertyValueFactory<>("NamaMinuman"));
        tcQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        tcHarga.setCellValueFactory(new PropertyValueFactory<>("Total"));
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Minuman.NamaMinuman, DetailOrder.Quantity, DetailOrder.Total FROM Minuman, DetailOrder WHERE Minuman.MinumanID = DetailOrder.MinumanID AND TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                order tvPesananSaya = new order(rs.getString("NamaMinuman"), (rs.getInt("Quantity")), (rs.getInt("Total")));
                ll.add(tvPesananSaya);
            }
            tvPesananSaya.getItems().clear();
            tvPesananSaya.getItems().addAll(ll);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

}
