import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Dashboard implements Initializable {

    @FXML
    private Button btnDaftarMember;

    @FXML
    private Button btnInventaris;

    @FXML
    private Button btnLaporanPembelian;

    @FXML
    private Button btnLaporanPendapatan;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnPembelian;

    @FXML
    private ComboBox<String> cbBulan;

    @FXML
    private Label labelTotalPelanggan;

    @FXML
    private Label labelTotalPembelian;

    @FXML
    private Label labelTotalPendapatan;

    @FXML
    private ListView<String> topSales;

    @FXML
    private ListView<String> lvStokSegeraHabis;
    
    Connection con = connection.kofiloConnection();

    @FXML
    void btnDaftarMember(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnDaftarMember.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DaftarMember.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnInventaris(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnInventaris.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Inventaris.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnLaporanPembelian(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLaporanPembelian.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("LaporanPembelian.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnLaporanPendapatan(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLaporanPendapatan.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("LaporanPendapatan.fxml"));
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
    void btnPembelian(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPembelian.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Pembelian.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void bulan(ActionEvent event) {
        String bulan = cbBulan.getSelectionModel().getSelectedItem();
        if(bulan == "Januari 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='01' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='01' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='01' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Februari 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='02' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='02' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='02' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Maret 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='03' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='03' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='03' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "April 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='04' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='04' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='04' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Mei 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='05' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='05' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='05' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Juni 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='06' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='06' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='06' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Juli 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='07' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='07' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='07' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Agustus 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='08' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='08' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='08' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "September 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='09' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='09' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='09' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Oktober 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='10' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='10' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='09' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "November 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='11' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='11' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='09' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
        if(bulan == "Desember 2022"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi WHERE MONTH(TanggalTransaksi)='12' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian WHERE MONTH(TanggalTransaksi)='12' AND YEAR(TanggalTransaksi)='2022'";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID AND MONTH(Transaksi.TanggalTransaksi)='09' AND YEAR(Transaksi.TanggalTransaksi)='2022' GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }if(bulan == "All"){
            try {
                labelTotalPendapatan.setText(null);
                labelTotalPembelian.setText(null);
                topSales.getItems().clear();
                Statement st = con.createStatement();
                String sql1 = "SELECT SUM(Total) FROM Transaksi";
                ResultSet rs1 = st.executeQuery(sql1);
                while (rs1.next()) {
                    if(rs1.getString(1)==null){
                        labelTotalPendapatan.setText("Rp 0");
                    }else
                        labelTotalPendapatan.setText("Rp " + rs1.getString(1));
                }         
                String sql2 = "SELECT SUM(TotalHargaBeli) FROM Pembelian";
                ResultSet rs2 = st.executeQuery(sql2);
                while(rs2.next()){
                    if(rs2.getString(1)==null){
                        labelTotalPembelian.setText("Rp 0");
                    }else
                        labelTotalPembelian.setText("Rp " + rs2.getString(1));
                }
                String sql3 = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
                ResultSet rs = st.executeQuery(sql3);
                while(rs.next()){
                    topSales.getItems().add(rs.getString("NamaMinuman"));
                }
    
            } catch (Exception e) {
                e.getStackTrace();
                e.getCause();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbBulan.getItems().add("All");
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

        getTotalPelanggan();
        labelTotalPendapatan.setText("Rp 0");
        labelTotalPembelian.setText("Rp 0");
        getTopSales();
        getStokSegeraHabis();

    }

    private void getTotalPelanggan(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT COUNT(UserID) FROM User WHERE UserStatus ='N' OR UserStatus = 'M'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                labelTotalPelanggan.setText(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    private void getTopSales() {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Minuman.NamaMinuman FROM DetailOrder, Minuman, Transaksi WHERE DetailOrder.MinumanID = Minuman.MinumanID AND Transaksi.TransaksiID = DetailOrder.TransaksiID GROUP BY Minuman.NamaMinuman ORDER BY sum(DetailOrder.Quantity) DESC LIMIT 5";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                topSales.getItems().add(rs.getString("NamaMinuman"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    private void getStokSegeraHabis() {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT NamaBahan FROM namabahan WHERE Quantity<250";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lvStokSegeraHabis.getItems().add(rs.getString("NamaBahan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}