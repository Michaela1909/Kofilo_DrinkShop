import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PembelianAdmin implements Initializable {

    public int NamaBahanID;

    @FXML
    private ComboBox<String> NamaProduk;

    @FXML
    private ImageView back;

    @FXML
    private Button btnKirimPembelian;

    @FXML
    private Button btnLogOut;

    @FXML
    private TextField tfQuantity;

    @FXML
    private TextField tfTotalPembelian;

    Connection con = connection.kofiloConnection(); 
    PreparedStatement pst; 
    int Harga;

    @FXML
    void NamaProduk(ActionEvent event) {
        String s = NamaProduk.getSelectionModel().getSelectedItem().toString();
        if (s=="Kopi Bubuk") {
            Harga = 50;
            NamaBahanID=1;
        }
        if (s=="Susu Full Cream") {
            Harga = 30;
            NamaBahanID=2;
        }
        if (s=="Cokelat Bubuk") {
            Harga = 50;
            NamaBahanID=3;
        }
        if (s=="Sirup Vanilla") {
            Harga = 45;
            NamaBahanID=4;
        }
        if (s=="Saus Karamel") {
            Harga = 45;
            NamaBahanID=5;
        }
        if (s=="Saus Cokelat") {
            Harga = 45;
            NamaBahanID=6;
        }
        if (s=="Whipped Cream") {
            Harga = 30; 
            NamaBahanID=7;
        }
        if (s=="Susu Kental Manis") {
            Harga = 20; 
            NamaBahanID=8;
        }
        if (s=="Garam") {
            Harga = 5; 
            NamaBahanID=9;
        }
        if (s=="Chocolate Chips") {
            Harga = 30;
            NamaBahanID=10;
        }
        if (s=="Gula Merah") {
            Harga = 10; 
            NamaBahanID=11;
        }
        if (s=="Gula Putih") {
            Harga = 10; 
            NamaBahanID=12;
        }
        if (s=="Susu Fresh Milk") {
            Harga = 30; 
            NamaBahanID=13;
        }
        if (s=="Bubuk Matcha") {
            Harga = 30; 
            NamaBahanID=14;
        }
        if (s=="Creamer Bubuk") {
            Harga = 20;
            NamaBahanID=15;
        }
        int quantity = Integer.parseInt(tfQuantity.getText());
        int total = quantity * Harga;
        tfTotalPembelian.setText(Integer.toString(total));
    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @FXML
    void btnKirimPembelian(ActionEvent event) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
            LocalDateTime now = LocalDateTime.now();  
            if (NamaProduk.getValue()==null || tfQuantity.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Textfield Kosong");
                alert.setContentText("Input Textfield!");
                alert.showAndWait();
            } else {
                pst = con.prepareStatement("INSERT INTO Pembelian(NamaBahanID, Quantity, TotalHargaBeli, TanggalTransaksi) VALUES (?, ?, ?, ?)");
                pst.setInt(1, NamaBahanID);
                pst.setInt(2, Integer.parseInt(tfQuantity.getText()));
                pst.setInt(3, Integer.parseInt(tfTotalPembelian.getText()));
                pst.setString(4, dtf.format(now));
                int status = pst.executeUpdate();

                if (status == -1) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Terjadi kesalahan");
                    alert.setContentText("Silahkan coba lagi!");
                    alert.showAndWait();
                } else {
                    pst = con.prepareStatement("UPDATE NamaBahan,Pembelian SET NamaBahan.Quantity = NamaBahan.Quantity + (SELECT Quantity FROM Pembelian ORDER BY PembelianID DESC LIMIT 1) WHERE Pembelian.NamaBahanID = NamaBahan.NamaBahanID AND Pembelian.NamaBahanID = " + NamaBahanID + "");
                    int statusUpdate = pst.executeUpdate();
                    if (statusUpdate!=-1) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Berhasil");
                        alert.setHeaderText("Anda Berhasil membeli " + NamaProduk.getSelectionModel().getSelectedItem());
                        alert.showAndWait();

                        tfQuantity.setText(null);
                        tfTotalPembelian.setText(null);
                        NamaProduk.getSelectionModel().clearSelection();;
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Terjadi kesalahan");
                        alert.setContentText("Silahkan coba lagi!");
                        alert.showAndWait();
                    }
                }
            }
        } catch (Exception e) {
            e.getCause();
            e.printStackTrace();
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
    void quantity(ActionEvent event) {
        int quantity = Integer.parseInt(tfQuantity.getText());
        int total = quantity * Harga;
        tfTotalPembelian.setText(Integer.toString(total));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("Kopi Bubuk", "Susu Full Cream", "Cokelat Bubuk", "Sirup Vanilla", "Saus Karamel", "Saus Cokelat", "Whipped Cream", "Susu Kental Manis", "Garam", "Chocolate Chips", "Gula Merah", "Gula Putih", "Susu Fresh Milk", "Bubuk Matcha", "Creamer Bubuk");
        NamaProduk.setItems(list);
    }
}
