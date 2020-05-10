package edu.nick.cursach.form;

public class AddedTransportForm {

    private String dateAdded;
    private String brand;
    private String info;

    public AddedTransportForm() {
    }

    public AddedTransportForm(String dateAdded, String brand, String info) {
        this.dateAdded = dateAdded;
        this.brand = brand;
        this.info = info;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "AddedTransportForm{" +
                ", dateAdded=" + dateAdded +
                ", brand='" + brand + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
