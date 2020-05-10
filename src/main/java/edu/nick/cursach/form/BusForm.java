package edu.nick.cursach.form;

public class BusForm {

    private String brand;
    private int seatingCapacity;
    private String serviceClass;
    private String route;
    private String storageObj;
    private int trackNumber;

    public BusForm() {
    }

    public BusForm(String brand, int seatingCapacity, String serviceClass, String route, String storageObj, int trackNumber) {
        this.brand = brand;
        this.seatingCapacity = seatingCapacity;
        this.serviceClass = serviceClass;
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

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
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
        return "BusForm{" +
                "brand='" + brand + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", serviceClass='" + serviceClass + '\'' +
                ", route='" + route + '\'' +
                ", storageObj='" + storageObj + '\'' +
                ", trackNumber=" + trackNumber +
                '}';
    }
}
