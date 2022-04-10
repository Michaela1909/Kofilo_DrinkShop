package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class laporan {
    private SimpleStringProperty NamaBahan;
    private SimpleIntegerProperty Quantity;
    private SimpleIntegerProperty HargaBeli;
    private SimpleIntegerProperty TotalHargaBeli;

    public laporan (String NamaBahan, int Quantity, int HargaBeli, int TotalHargaBeli) {
        this.NamaBahan = new SimpleStringProperty(NamaBahan);
        this.Quantity = new SimpleIntegerProperty(Quantity);
        this.HargaBeli = new SimpleIntegerProperty(HargaBeli);
        this.TotalHargaBeli = new SimpleIntegerProperty(TotalHargaBeli);
    }

    public String getNamaBahan() {
        return NamaBahan.get();
    }

    public void setNamaBahan(String NamaBahan) {
        this.NamaBahan.set(NamaBahan);
    }

    public Integer getQuantity() {
        return Quantity.get();
    }

    public void setQuantity(int Quantity) {
        this.Quantity.set(Quantity);
    }

    public Integer getHargaBeli() {
        return HargaBeli.get();
    }

    public void setHargaSatuan(int HargaBeli) {
        this.HargaBeli.set(HargaBeli);
    }

    public Integer getTotalHargaBeli() {
        return TotalHargaBeli.get();
    }

    public void setTotalHargaBeli(int TotalHargaBeli) {
        this.TotalHargaBeli.set(TotalHargaBeli);
    }
}