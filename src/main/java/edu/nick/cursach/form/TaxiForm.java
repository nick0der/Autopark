package edu.nick.cursach.form;

public class TaxiForm {

    private String brand;
    private int seatingCapacity;
    private String bodyType;
    private String storageObj;
    private int trackNumber;

    public TaxiForm() {
    }

    public TaxiForm(String brand, int seatingCapacity, String bodyType, String storageObj, int trackNumber) {
        this.brand = brand;
        this.seatingCapacity = seatingCapacity;
        this.bodyType = bodyType;
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

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
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
        return "TaxiForm{" +
                "brand='" + brand + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", bodyType='" + bodyType + '\'' +
                ", storageObj='" + storageObj + '\'' +
                ", trackNumber=" + trackNumber +
                '}';
    }
}
