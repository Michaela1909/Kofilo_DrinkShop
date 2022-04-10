package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class pendapatan {
    private SimpleStringProperty Username;
    private SimpleIntegerProperty UserID;
    private SimpleStringProperty TanggalTransaksi;
    private SimpleStringProperty MetodeTransaksi;
    private SimpleIntegerProperty Total;

    public pendapatan(String Username, int UserID, String TanggalTransaksi, String MetodeTransaksi, int Total){
        this.Username = new SimpleStringProperty(Username);
        this.UserID = new SimpleIntegerProperty(UserID);
        this.TanggalTransaksi = new SimpleStringProperty(TanggalTransaksi);
        this.MetodeTransaksi = new SimpleStringProperty(MetodeTransaksi);
        this.Total = new SimpleIntegerProperty(Total);
    }

    public String getUsername(){
        return Username.get();
    }
    public void setUsername(String inputUsername){
        Username.set(inputUsername);
    }
    public int getUserID(){
        return UserID.get();
    }
    public void setUserID(int inputUserID){
        UserID.set(inputUserID);
    }
    public String getTanggalTransaksi(){
        return TanggalTransaksi.get();
    }
    public void setTanggalTransaksi(String inputTanggalTransaksi){
        TanggalTransaksi.set(inputTanggalTransaksi);
    }
    public String getMetodeTransaksi(){
        return MetodeTransaksi.get();
    }
    public void setMetodeTransaksi(String inputMetodeTransaksi){
        MetodeTransaksi.set(inputMetodeTransaksi);
    }
    public int getTotal(){
        return Total.get();
    }
    public void setTotal(int inputTotal){
        Total.set(inputTotal);
    }
}
