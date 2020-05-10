package edu.nick.cursach.form;

public class FreightTransportForm {

    private String brand;
    private int loadCapacity;
    private String type;
    private String storageObj;
    private int trackNumber;

    public FreightTransportForm() {
    }

    public FreightTransportForm(String brand, int loadCapacity, String type, String storageObj, int trackNumber) {
        this.brand = brand;
        this.loadCapacity = loadCapacity;
        this.type = type;
        this.storageObj = storageObj;
        this.trackNumber = trackNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "FreightTransportForm{" +
                "brand='" + brand + '\'' +
                ", loadCapacity=" + loadCapacity +
                ", type='" + type + '\'' +
                ", storageObj='" + storageObj + '\'' +
                ", trackNumber=" + trackNumber +
                '}';
    }
}
