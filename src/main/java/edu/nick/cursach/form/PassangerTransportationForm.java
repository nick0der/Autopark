package edu.nick.cursach.form;

import java.time.LocalDateTime;

public class PassangerTransportationForm {

    private String dateTransported;
    private String transport;
    private int numberOfPassangers;

    public PassangerTransportationForm() {
    }

    public PassangerTransportationForm(String dateTransported, String transport, int numberOfPassangers) {
        this.dateTransported = dateTransported;
        this.transport = transport;
        this.numberOfPassangers = numberOfPassangers;
    }

    public String getDateTransported() {
        return dateTransported;
    }

    public void setDateTransported(String dateTransported) {
        this.dateTransported = dateTransported;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getNumberOfPassangers() {
        return numberOfPassangers;
    }

    public void setNumberOfPassangers(int numberOfPassangers) {
        this.numberOfPassangers = numberOfPassangers;
    }

    @Override
    public String toString() {
        return "PassangerTransportationForm{" +
                "dateTransported=" + dateTransported +
                ", transport=" + transport +
                ", numberOfPassangers=" + numberOfPassangers +
                '}';
    }
}
