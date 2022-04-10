package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class order {
    private SimpleStringProperty NamaMinuman;
    private SimpleIntegerProperty Quantity;
    private SimpleIntegerProperty Total;

    public order(String inputNamaMinuman, int inputQuantity, int inputTotal){
        this.NamaMinuman = new SimpleStringProperty(inputNamaMinuman);
        this.Quantity = new SimpleIntegerProperty(inputQuantity);
        this.Total = new SimpleIntegerProperty(inputTotal);
    }

    public String getNamaMinuman(){
        return NamaMinuman.get();
    }
    public void setNamaMinuman(String inputNamaMinuman){
        NamaMinuman.set(inputNamaMinuman);
    }
    public int getQuantity(){
        return Quantity.get();
    }
    public void setQuantity (int inputQuantity){
        Quantity.set(inputQuantity);
    }
    public int getTotal(){
        return Total.get();
    }
    public void setTotal(int inputTotal){
        Total.set(inputTotal);
    }
}
