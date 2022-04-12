import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class userProduct implements Initializable{

    @FXML
    private VBox CAmericanoBox;

    @FXML
    private VBox CCappucinoBox;

    @FXML
    private VBox CMoccacinoBox;

    @FXML
    private VBox CVanillaLatteBox;

    @FXML
    private Label CategoryLabel;

    @FXML
    private VBox HAmericanoBox;

    @FXML
    private VBox HCappucinoBox;

    @FXML
    private VBox HEspressonBox;

    @FXML
    private VBox HLatteBox;

    @FXML
    private ImageView ImageSrc;

    @FXML
    private Label NameLabel;

    @FXML
    private Label PriceLabel;

    @FXML
    private VBox SCaramelMachiatoBox;

    @FXML
    private VBox SJavaChipFrappeBox;

    @FXML
    private VBox SMatchaFrappeBox;

    @FXML
    private VBox SSaltedCaramelLatteBox;

    @FXML
    private Button btnAddItem;

    @FXML
    private Button btnCheckout;

    @FXML
    private Button btnLogout;

    @FXML
    private ComboBox<String> quantity;

    Connection con = connection.kofiloConnection(); 
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    void CAmericanoBox(MouseEvent event) {
        String Name = "Iced Americano";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>20");
            if(rs.next()){
                NameLabel.setText(Name);
                CategoryLabel.setText("Cold");
                PriceLabel.setText("Rp 30000");
                Image newImage = new Image(getClass().getResourceAsStream("/pic/IcedAmericano.png"));
                ImageSrc.setImage(newImage);
            }else{
                errorMsg();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }
    

    @FXML
    void CCappucinoBox(MouseEvent event) {
        String Name = "Iced Cappucino";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 7 AND NamaBahan.Quantity>50");
            if(rs.next()){
                ResultSet rs1 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 12 AND NamaBahan.Quantity>10");
                if(rs1.next()){
                    ResultSet rs2 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>5");
                    if(rs2.next()){
                        ResultSet rs3 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 11 AND NamaBahan.Quantity>5");
                        if(rs3.next()){
                            ResultSet rs4 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 3 AND NamaBahan.Quantity>2");
                            if(rs4.next()){
                                NameLabel.setText(Name);
                                CategoryLabel.setText("Cold");
                                PriceLabel.setText("Rp 30000");
                                Image newImage = new Image(getClass().getResourceAsStream("/pic/IcedCappucino.png"));
                                ImageSrc.setImage(newImage);
                            }else{
                                errorMsg();
                            }
                        }else{
                            errorMsg();
                        }

                    }else{
                        errorMsg();
                    }

                }else{
                    errorMsg();
                }

            }else{
                errorMsg();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void CMoccacinoBox(MouseEvent event) {
        String Name = "Iced Mocaccino";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 7 AND NamaBahan.Quantity>50");
            if(rs.next()){
                ResultSet rs1 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 12 AND NamaBahan.Quantity>10");
                if(rs1.next()){
                    ResultSet rs2 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 3 AND NamaBahan.Quantity>5");
                    if(rs2.next()){
                        ResultSet rs3 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 11 AND NamaBahan.Quantity>5");
                        if(rs3.next()){
                            ResultSet rs4 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>2");
                            if(rs4.next()){
                                NameLabel.setText(Name);
                                CategoryLabel.setText("Cold");
                                PriceLabel.setText("Rp 35000");
                                Image newImage = new Image(getClass().getResourceAsStream("/pic/IcedMoccacino.png"));
                                ImageSrc.setImage(newImage);
                            }else{
                                errorMsg();
                            }
                        }else{
                            errorMsg();
                        }

                    }else{
                        errorMsg();
                    }

                }else{
                    errorMsg();
                }

            }else{
                errorMsg();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    @FXML
    void CVanillaLatteBox(MouseEvent event) {
        String Name = "Iced Vanilla Latte";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 13 AND NamaBahan.Quantity>200");
            if(rs.next()){
                ResultSet rs1 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 4 AND NamaBahan.Quantity>20");
                if(rs1.next()){
                    ResultSet rs2 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>5");
                    if(rs2.next()){
                        ResultSet rs3 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 12 AND NamaBahan.Quantity>5");
                        if(rs3.next()){
                            NameLabel.setText(Name);
                            CategoryLabel.setText("Cold");
                            PriceLabel.setText("Rp 45000");
                            Image newImage = new Image(getClass().getResourceAsStream("/pic/IcedVanillaLatte.png"));
                            ImageSrc.setImage(newImage);
                        }else{
                            errorMsg();
                        }
                    }else{
                        errorMsg();
                    }
                }else{
                    errorMsg();
                }
            }else{
                errorMsg();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
 
       
    

    @FXML
    void HAmericanoBoxHAmericanoBox(MouseEvent event) {
        String Name = "Hot Americano";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>20");
            if(rs.next()){
                NameLabel.setText(Name);
                CategoryLabel.setText("Hot");
                PriceLabel.setText("Rp 35000");
                Image newImage = new Image(getClass().getResourceAsStream("/pic/HotAmericano.png"));
                ImageSrc.setImage(newImage);
            }else{
                errorMsg();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void HCappucinoBox(MouseEvent event) {
        String Name = "Hot Cappucino";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 7 AND NamaBahan.Quantity>50");
            if(rs.next()){
                ResultSet rs1 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 12 AND NamaBahan.Quantity>10");
                if(rs1.next()){
                    ResultSet rs2 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>5");
                    if(rs2.next()){
                        ResultSet rs3 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 11 AND NamaBahan.Quantity>5");
                        if(rs3.next()){
                            ResultSet rs4 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 3 AND NamaBahan.Quantity>2");
                            if(rs4.next()){
                                NameLabel.setText(Name);
                                CategoryLabel.setText("Hot");
                                PriceLabel.setText("Rp 45000");
                                Image newImage = new Image(getClass().getResourceAsStream("/pic/HotCappucino.png"));
                                ImageSrc.setImage(newImage);
                            }else{
                                errorMsg();
                            }
                        }else{
                            errorMsg();
                        }

                    }else{
                        errorMsg();
                    }

                }else{
                    errorMsg();
                }

            }else{
                errorMsg();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }

        
    }

    @FXML
    void HEspressoBox(MouseEvent event) {
        String Name = "Hot Espresso";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>20");
            if(rs.next()){
                NameLabel.setText(Name);
                CategoryLabel.setText("Hot");
                PriceLabel.setText("Rp 35000");
                Image newImage = new Image(getClass().getResourceAsStream("/pic/HotEspresso.png"));
                ImageSrc.setImage(newImage);
            }else{
                errorMsg();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }

        
    }

    @FXML
    void HLatteBox(MouseEvent event) {
        String Name = "Hot Latte";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 13 AND NamaBahan.Quantity>150");
            if(rs.next()){
                ResultSet rs1 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 12 AND NamaBahan.Quantity>25");
                if(rs1.next()){
                    ResultSet rs2 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>10");
                    if(rs2.next()){
                        NameLabel.setText(Name);
                        CategoryLabel.setText("Hot");
                        PriceLabel.setText("Rp 40000");
                        Image newImage = new Image(getClass().getResourceAsStream("/pic/HotLatte.png"));
                        ImageSrc.setImage(newImage);
                    }else{
                        errorMsg();
                    }
                }else{
                    errorMsg();
                }
            }else{
                errorMsg();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }

        
    }

    @FXML
    void SCaramelMachiatoBox(MouseEvent event) {
        String Name = "Caramel Machiato";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 2 AND NamaBahan.Quantity>150");
            if(rs.next()){
                ResultSet rs1 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 7 AND NamaBahan.Quantity>100");
                if(rs1.next()){
                    ResultSet rs2 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 4 AND NamaBahan.Quantity>20");
                    if(rs2.next()){
                        ResultSet rs3 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 5 AND NamaBahan.Quantity>10");
                        if(rs3.next()){
                            ResultSet rs4 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>5");
                            if(rs4.next()){
                                NameLabel.setText(Name);
                                CategoryLabel.setText("Signature");
                                PriceLabel.setText("Rp 45000");
                                Image newImage = new Image(getClass().getResourceAsStream("/pic/SignatureCaramelMachiato.png"));
                                ImageSrc.setImage(newImage);
                            }else{
                                errorMsg();
                            }
                            
                        }else{
                            errorMsg();
                        }
                        
                    }else{
                        errorMsg();
                    }
                    
                }else{
                    errorMsg();
                }
            }else{
                errorMsg();
            }
        }catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }   
    }

    @FXML
    void SJavaChipFrappeBox(MouseEvent event) {
        String Name = "Java Chip Frape";
        try {
            Statement st = con.createStatement();
            //String sql1 = "SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = ";
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 13 AND NamaBahan.Quantity>60");
            if(rs.next()){
                ResultSet rs1 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>10");
                if(rs1.next()){
                    ResultSet rs2 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 6 AND NamaBahan.Quantity>20");
                    if(rs2.next()){
                        ResultSet rs3 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 10 AND NamaBahan.Quantity>20");
                        if(rs3.next()){
                            NameLabel.setText(Name);
                            CategoryLabel.setText("Signature");
                            PriceLabel.setText("Rp 55000");
                            Image newImage = new Image(getClass().getResourceAsStream("/pic/SignatureJavaChipFrappe.png"));
                            ImageSrc.setImage(newImage);
                        }else{
                            errorMsg();
                        }
                        
                    }else{
                        errorMsg();
                    }
                    
                }else{
                    errorMsg();
                }
                
            }else{
                errorMsg();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
        
    }

    @FXML
    void SMatchaFrappeBox(MouseEvent event) {
        String Name = "Matcha Frappe";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 13 AND NamaBahan.Quantity>200");
            if(rs.next()){
                ResultSet rs1 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 8 AND NamaBahan.Quantity>180");
                if(rs1.next()){
                    ResultSet rs2 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 7 AND NamaBahan.Quantity>100");
                    if(rs2.next()){
                        ResultSet rs3 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 15 AND NamaBahan.Quantity>20");
                        if(rs3.next()){
                            ResultSet rs4 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 14 AND NamaBahan.Quantity>10");
                            if(rs4.next()){
                                NameLabel.setText(Name);
                                CategoryLabel.setText("Signature");
                                PriceLabel.setText("Rp 55000");
                                Image newImage = new Image(getClass().getResourceAsStream("/pic/SignatureMatchaFrappe.png"));
                                ImageSrc.setImage(newImage);
                            }else{
                                errorMsg();
                            }
                            
                        }else{
                            errorMsg();
                        }
                        
                    }else{
                        errorMsg();
                    }
                    
                }else{
                    errorMsg();
                }
            }else{
                errorMsg();
            }
        }catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }   
        
    }

    @FXML
    void SSaltedCaramelLatteBox(MouseEvent event) {
        String Name = "Salted Caramel Latte";
        try {
            Statement st = con.createStatement();
            //String sql1 = "SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = ";
            ResultSet rs = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 13 AND NamaBahan.Quantity>55");
            if(rs.next()){
                ResultSet rs1 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 1 AND NamaBahan.Quantity>10");
                if(rs1.next()){
                    ResultSet rs2 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 5 AND NamaBahan.Quantity>10");
                    if(rs2.next()){
                        ResultSet rs3 = st.executeQuery("SELECT NamaBahan.Quantity FROM NamaBahan WHERE NamaBahanID = 9 AND NamaBahan.Quantity>1");
                        if(rs3.next()){
                            NameLabel.setText(Name);
                            CategoryLabel.setText("Signature");
                            PriceLabel.setText("Rp 55000");
                            Image newImage = new Image(getClass().getResourceAsStream("/pic/SignatureSaltedCaramelLatte.png"));
                            ImageSrc.setImage(newImage); 
                        }else{
                            errorMsg();
                        }
                        
                    }else{
                        errorMsg();
                    }
                    
                }else{
                    errorMsg();
                }
                
            }else{
                errorMsg();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
              
        
    }


    @FXML
    void AddItem(ActionEvent event) throws ClassNotFoundException{
        try {
            if (quantity.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Tentukan Quantity");
                alert.setContentText(null);
                alert.showAndWait();
            } else {
                pst = con.prepareStatement("INSERT INTO DetailOrder SET TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), MinumanID = (SELECT MinumanID FROM Minuman WHERE NamaMinuman = ? ), Quantity = ?, Total = 0");
                pst.setString(1, NameLabel.getText());
                pst.setString(2, quantity.getSelectionModel().getSelectedItem());
                
                int status = pst.executeUpdate();
                if(status == -1){
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Terjadi kesalahan");
                    alert.setContentText("Silahkan coba lagi!");
                    alert.showAndWait();
                }else{
                    pst = con.prepareStatement("UPDATE DetailOrder INNER JOIN Minuman on DetailOrder.MinumanID = Minuman.MinumanID SET DetailOrder.Total = DetailOrder.Quantity * Minuman.Harga");
                    //String sqlUpdate = "UPDATE detailorder INNER JOIN minuman on detailorder.MinumanID = minuman.MinumanID SET detailorder.Total = detailorder.Quantity * minuman.Harga";
                    int statusUpdate = pst.executeUpdate();
                    if(statusUpdate!=-1){
                        pst = con.prepareStatement("UPDATE NamaBahan, Bahan, DetailOrder SET NamaBahan.Quantity = NamaBahan.Quantity - (Bahan.Quantity * DetailOrder.Quantity) WHERE DetailOrder.MinumanID = Bahan.MinumanID AND bahan.NamaBahanID = NamaBahan.NamaBahanID AND DetailOrder.DetailOrderID = (SELECT DetailOrderID FROM DetailOrder ORDER BY DetailOrderID DESC LIMIT 1)");
                        pst.executeUpdate();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Berhasil");
                        alert.setHeaderText("Anda Berhasil Menambahkan Item Baru!");
                        alert.setContentText("Terima Kasih.");
                        alert.showAndWait();

                        quantity.getSelectionModel().clearSelection();
                    }else{
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Terjadi kesalahan");
                        alert.setContentText("Silahkan coba lagi!");
                        alert.showAndWait();
                    }

                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            e.getCause();
        }
    }
    @FXML
    void selectQuantity(ActionEvent event) {
        //String s = quantity.getSelectionModel().getSelectedItem().toString();

    }

    @FXML
    void Checkout(ActionEvent event) throws IOException {
        try {
            if (quantity.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Tentukan Produk dan Quantity!");
                alert.setContentText(null);
                alert.showAndWait();
            } else {
                Stage stage = (Stage) btnLogout.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("AfterUserProduct.fxml"));
                stage.setTitle("Kofilo");
                stage.setScene(new Scene(root));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    @FXML
    void Logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage.setTitle("Kofilo");
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        ObservableList<String> list = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
        quantity.setItems(list);
    }
    public void errorMsg(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Persediaan menu habis");
        //alert.setContentText("Silahkan coba lagi!");
        alert.showAndWait();
    }
}

