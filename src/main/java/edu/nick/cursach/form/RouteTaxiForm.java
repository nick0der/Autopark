package edu.nick.cursach.form;

public class RouteTaxiForm {

    private String brand;
    private int seatingCapacity;
    private int number;
    private String route;
    private String storageObj;
    private int trackNumber;

    public RouteTaxiForm() {
    }

    public RouteTaxiForm(String brand, int seatingCapacity, int number, String route, String storageObj, int trackNumber) {
        this.brand = brand;
        this.seatingCapacity = seatingCapacity;
        this.number = number;
        this.route = route;
        this.storageObj = storageObj;
        this.trackNumber = trackNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStorageObj() {
        return storageObj;
    }

    public void setStorageObj(String storageObj) {
        this.storageObj = storageObj;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    @Override
    public String toString() {
        return "RouteTaxiForm{" +
                "brand='" + brand + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", number=" + number +
                ", route='" + route + '\'' +
                ", storageObj='" + storageObj + '\'' +
                ", trackNumber=" + trackNumber +
                '}';
    }
}
