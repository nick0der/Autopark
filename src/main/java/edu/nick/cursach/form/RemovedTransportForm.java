package edu.nick.cursach.form;

import java.time.LocalDate;

public class RemovedTransportForm {

    private String dateRemoved;
    private String brand;
    private String info;

    public RemovedTransportForm() {
    }

    public RemovedTransportForm(String dateRemoved, String brand, String info) {
        this.dateRemoved = dateRemoved;
        this.brand = brand;
        this.info = info;
    }

    public String getDateRemoved() {
        return dateRemoved;
    }

    public void setDateRemoved(String dateRemoved) {
        this.dateRemoved = dateRemoved;
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
        return "RemovedTransportForm{" +
                "dateRemoved=" + dateRemoved +
                ", brand='" + brand + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
