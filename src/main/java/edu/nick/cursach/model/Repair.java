package edu.nick.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Repair {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private LocalDate dateRepaired;
    private Transport transport;
    private int cost;
    private WorkingTeam workingTeam;
    private int engines;
    private int transmissions;
    private int bridges;
    private int chassis;

    public Repair() {
    }

    public Repair(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, LocalDate dateRepaired, Transport transport, int cost, WorkingTeam workingTeam, int engines, int transmissions, int bridges, int chassis) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.dateRepaired = dateRepaired;
        this.transport = transport;
        this.cost = cost;
        this.workingTeam = workingTeam;
        this.engines = engines;
        this.transmissions = transmissions;
        this.bridges = bridges;
        this.chassis = chassis;
    }

    public Repair(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, LocalDate dateRepaired, Transport transport, int cost, WorkingTeam workingTeam, int engines, int transmissions, int bridges, int chassis) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.dateRepaired = dateRepaired;
        this.transport = transport;
        this.cost = cost;
        this.workingTeam = workingTeam;
        this.engines = engines;
        this.transmissions = transmissions;
        this.bridges = bridges;
        this.chassis = chassis;
    }

    public Repair(String name, String description, LocalDate dateRepaired, Transport transport, int cost, WorkingTeam workingTeam, int engines, int transmissions, int bridges, int chassis) {
        this.name = name;
        this.description = description;
        this.dateRepaired = dateRepaired;
        this.transport = transport;
        this.cost = cost;
        this.workingTeam = workingTeam;
        this.engines = engines;
        this.transmissions = transmissions;
        this.bridges = bridges;
        this.chassis = chassis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public LocalDate getDateRepaired() {
        return dateRepaired;
    }

    public void setDateRepaired(LocalDate dateRepaired) {
        this.dateRepaired = dateRepaired;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public WorkingTeam getWorkingTeam() {
        return workingTeam;
    }

    public void setWorkingTeam(WorkingTeam workingTeam) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repair repair = (Repair) o;
        return id.equals(repair.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
