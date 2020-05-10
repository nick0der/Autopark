package edu.nick.cursach.form;

public class UsageOfAncillaryTransportForm {

    private String dateUsed;
    private String ancillaryTransport;

    public UsageOfAncillaryTransportForm() {
    }

    public UsageOfAncillaryTransportForm(String dateUsed, String ancillaryTransport) {
        this.dateUsed = dateUsed;
        this.ancillaryTransport = ancillaryTransport;
    }

    public String getDateUsed() {
        return dateUsed;
    }

    public void setDateUsed(String dateUsed) {
        this.dateUsed = dateUsed;
    }

    public String getAncillaryTransport() {
        return ancillaryTransport;
    }

    public void setAncillaryTransport(String ancillaryTransport) {
        this.ancillaryTransport = ancillaryTransport;
    }

    @Override
    public String toString() {
        return "UsageOfAncillaryTransportForm{" +
                "dateUsed=" + dateUsed +
                ", ancillaryTransport=" + ancillaryTransport +
                '}';
    }
}
