package edu.nick.cursach.form;

import java.time.LocalDateTime;

public class KilometrageForm {

    private String dateRecorded;
    private String transport;
    private int kilometers;

    public KilometrageForm() {
    }

    public KilometrageForm(String dateRecorded, String transport, int kilometers) {
        this.dateRecorded = dateRecorded;
        this.transport = transport;
        this.kilometers = kilometers;
    }

    public String getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(String dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    public String toString() {
        return "KilometrageForm{" +
                "dateRecorded=" + dateRecorded +
                ", transport=" + transport +
                ", kilometers=" + kilometers +
                '}';
    }
}
