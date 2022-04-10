package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class bahan {
    private SimpleStringProperty NamaBahan;
    private SimpleIntegerProperty Quantity;
    private SimpleIntegerProperty HargaBeli;

    public bahan (String NamaBahan, int Quantity, int HargaBeli) {
        this.NamaBahan =  new SimpleStringProperty(NamaBahan);
        this.Quantity = new SimpleIntegerProperty(Quantity);
        this.HargaBeli = new SimpleIntegerProperty(HargaBeli);
    }

    public String getNamaBahan() {
        return NamaBahan.get();
    }

    public void setNamaBahan(String NamaBahan) {
        this.NamaBahan.set(NamaBahan);
    }

    public int getQuantity() {
        return Quantity.get();
    }

    public void setQuantity(int Quantity) {
        this.Quantity.set(Quantity);
    }

    public int getHargaBeli() {
        return HargaBeli.get();
    }

    public void setHargaBeli(int HargaBeli) {
        this.HargaBeli.set(HargaBeli);
    }
}

