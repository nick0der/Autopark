package edu.nick.cursach.form;

public class AncillaryTransportForm {

    private String brand;
    private String mission;
    private String storageObj;
    private int trackNumber;

    public AncillaryTransportForm() {
    }

    public AncillaryTransportForm(String brand, String mission, String storageObj, int trackNumber) {
        this.brand = brand;
        this.mission = mission;
        this.storageObj = storageObj;
        this.trackNumber = trackNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
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
        return "AncillaryTransportForm{" +
                "brand='" + brand + '\'' +
                ", mission='" + mission + '\'' +
                ", storageObj='" + storageObj + '\'' +
                ", trackNumber=" + trackNumber +
                '}';
    }
}
