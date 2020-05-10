package edu.nick.cursach.form;

public class TransportationForm {

    private String dateTransported;
    private int weight;
    private String freightTransport;

    public TransportationForm() {
    }

    public TransportationForm(String dateTransported, int weight, String freightTransport) {
        this.dateTransported = dateTransported;
        this.weight = weight;
        this.freightTransport = freightTransport;
    }

    public String getDateTransported() {
        return dateTransported;
    }

    public void setDateTransported(String dateTransported) {
        this.dateTransported = dateTransported;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getFreightTransport() {
        return freightTransport;
    }

    public void setFreightTransport(String freightTransport) {
        this.freightTransport = freightTransport;
    }

    @Override
    public String toString() {
        return "TransportationForm{" +
                "dateTransported=" + dateTransported +
                ", weight=" + weight +
                ", freightTransport=" + freightTransport +
                '}';
    }
}
