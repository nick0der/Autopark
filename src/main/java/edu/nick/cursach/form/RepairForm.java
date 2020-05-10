package edu.nick.cursach.form;

public class RepairForm {

    private String dateRepaired;
    private String transport;
    private String workingTeam;
    private int cost;
    private int engines;
    private int transmissions;
    private int bridges;
    private int chassis;

    public RepairForm() {
    }

    public RepairForm(String dateRepaired, String transport, int cost, String workingTeam, int engines, int transmissions, int bridges, int chassis) {
        this.dateRepaired = dateRepaired;
        this.transport = transport;
        this.cost = cost;
        this.workingTeam = workingTeam;
        this.engines = engines;
        this.transmissions = transmissions;
        this.bridges = bridges;
        this.chassis = chassis;
    }

    public String getDateRepaired() {
        return dateRepaired;
    }

    public void setDateRepaired(String dateRepaired) {
        this.dateRepaired = dateRepaired;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getWorkingTeam() {
        return workingTeam;
    }

    public void setWorkingTeam(String workingTeam) {
        this.workingTeam = workingTeam;
    }

    public int getEngines() {
        return engines;
    }

    public void setEngines(int engines) {
        this.engines = engines;
    }

    public int getTransmissions() {
        return transmissions;
    }

    public void setTransmissions(int transmissions) {
        this.transmissions = transmissions;
    }

    public int getBridges() {
        return bridges;
    }

    public void setBridges(int bridges) {
        this.bridges = bridges;
    }

    public int getChassis() {
        return chassis;
    }

    public void setChassis(int chassis) {
        this.chassis = chassis;
    }

    @Override
    public String toString() {
        return "RepairForm{" +
                "dateRepaired=" + dateRepaired +
                ", transport=" + transport +
                ", cost=" + cost +
                ", workingTeam=" + workingTeam +
                ", engines=" + engines +
                ", transmissions=" + transmissions +
                ", bridges=" + bridges +
                ", chassis=" + chassis +
                '}';
    }
}
