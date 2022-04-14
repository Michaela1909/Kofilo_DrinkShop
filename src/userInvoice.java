import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.order;

public class userInvoice implements Initializable{

    @FXML
    private ImageView back;

    @FXML
    private Label labelDiskon;

    @FXML
    private Label labelTotal;

    @FXML
    private Label labelTotalBelanja;

    @FXML
    private Button menuBtn;

    @FXML
    private TableView<order> order;

    @FXML
    private TableColumn<order, String> tc_harga;

    @FXML
    private TableColumn<order, String> tc_item;

    @FXML
    private TableColumn<order, String> tc_qty;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) menuBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("userCheckout.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void menuBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) menuBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("userProduct.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    Connection con = connection.kofiloConnection();
    LinkedList<order> ll = new LinkedList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
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
            getTotal();
            getDiskon();
            getTotalBelanja();
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getTotal(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT SUM(DetailOrder.Total) FROM DetailOrder WHERE TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                labelTotal.setText("Rp " + rs.getString(1));
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getDiskon(){
        try {
            Statement st1 = con.createStatement();
            String sql1 = "SELECT User.UserStatus FROM User, Transaksi WHERE Transaksi.UserID = User.UserID ORDER BY TransaksiID DESC LIMIT 1";
            ResultSet rs1 = st1.executeQuery(sql1);
            while(rs1.next()){
                if(rs1.getString(1).equals("M")){
                    labelDiskon.setText("Rp 10000");
                }else{
                    labelDiskon.setText("Rp 0");
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getTotalBelanja(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Total FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                labelTotalBelanja.setText("Rp " + rs.getString(1));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}

