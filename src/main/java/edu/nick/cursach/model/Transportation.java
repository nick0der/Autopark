package edu.nick.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Transportation {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private LocalDate dateTransported;
    private int weight;
    private FreightTransport freightTransport;

    public Transportation() {
    }

    public Transportation(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, LocalDate dateTransported, int weight, FreightTransport freightTransport) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.dateTransported = dateTransported;
        this.weight = weight;
        this.freightTransport = freightTransport;
    }

    public Transportation(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, LocalDate dateTransported, int weight, FreightTransport freightTransport) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.dateTransported = dateTransported;
        this.weight = weight;
        this.freightTransport = freightTransport;
    }

    public Transportation(String name, String description, LocalDate dateTransported, int weight, FreightTransport freightTransport) {
        this.name = name;
        this.description = description;
        this.dateTransported = dateTransported;
        this.weight = weight;
        this.freightTransport = freightTransport;
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

    public LocalDate getDateTransported() {
        return dateTransported;
    }

    public void setDateTransported(LocalDate dateTransported) {
        this.dateTransported = dateTransported;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public FreightTransport getFreightTransport() {
        return freightTransport;
    }

    public void setFreightTransport(FreightTransport freightTransport) {
        this.freightTransport = freightTransport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportation that = (Transportation) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
