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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.pendapatan;

public class LaporanPendapatan {

    @FXML
    private ImageView back;

    @FXML
    private Button btnLogOut;

    @FXML
    private ComboBox<String> cbBulan;

    @FXML
    private TableColumn<pendapatan, String> tcMetodeTransaksi;

    @FXML
    private TableColumn<pendapatan, String> tcTanggalTransaksi;

    @FXML
    private TableColumn<pendapatan, Integer> tcTotal;

    @FXML
    private TableColumn<pendapatan, Integer> tcUserID;

    @FXML
    private TableColumn<pendapatan, String> tcUsername;

    @FXML
    private TableView<pendapatan> tvLaporanPenjualan;

    LinkedList<pendapatan> linkedList = new LinkedList<>();
    Connection con = connection.kofiloConnection();

    @FXML
    void Bulan(ActionEvent event) {
        //tvLaporanPenjualan.getItems().clear();
        String bulan = cbBulan.getSelectionModel().getSelectedItem();
        if(bulan == "Januari 2022"){
            try {
                linkedList.clear();
                //tvLaporanPenjualan.getItems().clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='01' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Februari 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='02' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Maret 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='03' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "April 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='04' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Mei 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='05' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Juni 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='06' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Juli 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='07' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Agustus 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='08' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "September 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='09' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Oktober 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='10' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "November 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='11' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Desember 2022"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID AND MONTH (Transaksi.TanggalTransaksi)='12' AND YEAR(Transaksi.TanggalTransaksi)='2022'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "All"){
            try {
                //tvLaporanPenjualan.getItems().clear();
                linkedList.clear();
                Statement st = con.createStatement();
                String sql = "SELECT User.Username, User.UserID, Transaksi.TanggalTransaksi, Transaksi.MetodeTransaksi, Transaksi.Total FROM User, Transaksi WHERE User.UserID = Transaksi.UserID ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    pendapatan tvLaporanPenjualan = new pendapatan(rs.getString("Username"), (rs.getInt("UserID")), (rs.getString("TanggalTransaksi")), (rs.getString("MetodeTransaksi")), (rs.getInt("Total")));
                    linkedList.add(tvLaporanPenjualan);
                }
                tvLaporanPenjualan.getItems().clear();
                tvLaporanPenjualan.getItems().addAll(linkedList);
                    
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
    }
    
    @FXML
    public void initialize() {
        cbBulan.getItems().add("Januari 2022");
        cbBulan.getItems().add("Februari 2022");
        cbBulan.getItems().add("Maret 2022");
        cbBulan.getItems().add("April 2022");
        cbBulan.getItems().add("Mei 2022");
        cbBulan.getItems().add("Juni 2022");
        cbBulan.getItems().add("Juli 2022");
        cbBulan.getItems().add("Agustus 2022");
        cbBulan.getItems().add("September 2022");
        cbBulan.getItems().add("Oktober 2022");
        cbBulan.getItems().add("November 2022");
        cbBulan.getItems().add("Desember 2022");
        cbBulan.getItems().add("All");

        tcUsername.setCellValueFactory(new PropertyValueFactory<>("Username"));
        tcUserID.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        tcTanggalTransaksi.setCellValueFactory(new PropertyValueFactory<>("TanggalTransaksi"));
        tcMetodeTransaksi.setCellValueFactory(new PropertyValueFactory<>("MetodeTransaksi"));
        tcTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));


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
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

}