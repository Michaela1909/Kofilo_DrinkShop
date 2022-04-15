import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.sql.Statement;
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
import javafx.stage.Stage;
import model.order;

public class userCheckout implements Initializable {

    @FXML
    private Button bayar;

    @FXML
    private Label labelDiskon;

    @FXML
    private Label labelTotal;

    @FXML
    private Label labelTotalBelanja;

    @FXML
    private ComboBox<String> metodePembayaranCb;

    @FXML
    private TableView<order> order;

    @FXML
    private TableColumn<order, Integer> tc_harga;

    @FXML
    private TableColumn<order, String> tc_item;

    @FXML
    private TableColumn<order, Integer> tc_qty;

    Connection con = connection.kofiloConnection();
    LinkedList<order> ll = new LinkedList<>();

    @FXML
    void bayarBtn(ActionEvent event) throws IOException {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT DetailOrder.DetailOrderID FROM DetailOrder WHERE TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                if (metodePembayaranCb.getSelectionModel().getSelectedItem() == null) {
                    MetodePembayaranMsg();
                } else {
                    updateMetodePembayaran();
                    Stage stage = (Stage) bayar.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("userInvoice.fxml"));
                    stage.setTitle("Kofilo");
                    stage.setScene(new Scene(root));
                }
            } else {
                errorMsg();
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void metodePembayaranCb(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        metodePembayaranCb.getItems().add("Cash");
        metodePembayaranCb.getItems().add("Transfer Bank");
        metodePembayaranCb.getItems().add("OVO");

        labelTotal.setText("Rp 0");
        labelDiskon.setText("");
        labelTotalBelanja.setText("Rp 0");

        tc_item.setCellValueFactory(new PropertyValueFactory<>("NamaMinuman"));
        tc_qty.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        tc_harga.setCellValueFactory(new PropertyValueFactory<>("Total"));
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Minuman.NamaMinuman, DetailOrder.Quantity, DetailOrder.Total FROM Minuman, DetailOrder WHERE Minuman.MinumanID = DetailOrder.MinumanID AND TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                order order = new order(rs.getString("NamaMinuman"), (rs.getInt("Quantity")), (rs.getInt("Total")));
                ll.add(order);
            }
            order.getItems().clear();
            order.getItems().addAll(ll);
            updateTotal();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void updateTotal() { 
        try {
            Statement st = con.createStatement();
            String sql = "SELECT SUM(DetailOrder.Total) FROM DetailOrder WHERE TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                labelTotal.setText("Rp " + rs.getString(1));
                try {
                    Statement st1 = con.createStatement();
                    String sql1 = "SELECT User.UserStatus FROM User, Transaksi WHERE Transaksi.UserID = User.UserID ORDER BY TransaksiID DESC LIMIT 1";
                    ResultSet rs1 = st1.executeQuery(sql1);
                    while (rs1.next()) {
                        if (rs1.getString(1).equals("M")) {
                            labelDiskon.setText("Rp 10000");
                            PreparedStatement pst = con.prepareStatement("UPDATE Transaksi SET Total = (SELECT SUM(Total)-10000 FROM DetailOrder WHERE DetailOrder.TransaksiID = Transaksi.TransaksiID) WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1;");
                            int stats = pst.executeUpdate();
                            if (stats!=-1) {
                                Statement st2 = con.createStatement();
                                String sql2 = "SELECT Total FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1";
                                ResultSet rs2 = st2.executeQuery(sql2);
                                while (rs2.next()) {
                                    labelTotalBelanja.setText("Rp " + rs2.getInt(1));
                                }
                            }
                        } else {
                            labelDiskon.setText("Rp 0");
                            PreparedStatement pst = con.prepareStatement("UPDATE Transaksi SET Total = (SELECT SUM(Total) FROM DetailOrder WHERE DetailOrder.TransaksiID = Transaksi.TransaksiID) WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1;");
                            int stats = pst.executeUpdate();
                            if (stats!=-1) {
                                Statement st2 = con.createStatement();
                                String sql2 = "SELECT Total FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1";
                                ResultSet rs2 = st2.executeQuery(sql2);
                                while (rs2.next()) {
                                    labelTotalBelanja.setText("Rp " + rs2.getInt(1));
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void updateMetodePembayaran() {
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("UPDATE Transaksi SET MetodeTransaksi = ? WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1");
            pst.setString(1, metodePembayaranCb.getSelectionModel().getSelectedItem());
            int stats = pst.executeUpdate();
            if (stats!=-1) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Anda Berhasil Melakukan Pembayaran Pesanan Anda!");
                alert.setContentText("Terima Kasih.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void errorMsg() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Silahkan coba lagi!");
        alert.setContentText("Silahkan pilih item yang anda ingin beli terlebih dahulu!");
        alert.showAndWait();
    }

    public void MetodePembayaranMsg() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Silahkan coba lagi!");
        alert.setContentText("Silahkan pilih metode pembayaran yang ingin digunakan terlebih dahulu!");
        alert.showAndWait();
    }
}
