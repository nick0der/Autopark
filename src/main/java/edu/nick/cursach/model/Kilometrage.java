package edu.nick.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Kilometrage {

    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private LocalDate dateRecorded;
    private Transport transport;
    private int kilometers;

    public Kilometrage() {
    }

    public Kilometrage(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, LocalDate dateRecorded, Transport transport, int kilometers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.dateRecorded = dateRecorded;
        this.transport = transport;
        this.kilometers = kilometers;
    }

    public Kilometrage(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, LocalDate dateRecorded, Transport transport, int kilometers) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.dateRecorded = dateRecorded;
        this.transport = transport;
        this.kilometers = kilometers;
    }

    public Kilometrage(String name, String description, LocalDate dateRecorded, Transport transport, int kilometers) {
        this.name = name;
        this.description = description;
        this.dateRecorded = dateRecorded;
        this.transport = transport;
        this.kilometers = kilometers;
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

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kilometrage that = (Kilometrage) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
