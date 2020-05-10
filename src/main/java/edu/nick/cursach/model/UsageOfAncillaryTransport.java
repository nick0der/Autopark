package edu.nick.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class UsageOfAncillaryTransport {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private LocalDate dateUsed;
    private AncillaryTransport ancillaryTransport;

    public UsageOfAncillaryTransport() {
    }

    public UsageOfAncillaryTransport(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, LocalDate dateUsed, AncillaryTransport ancillaryTransport) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.dateUsed = dateUsed;
        this.ancillaryTransport = ancillaryTransport;
    }

    public UsageOfAncillaryTransport(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, LocalDate dateUsed, AncillaryTransport ancillaryTransport) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.dateUsed = dateUsed;
        this.ancillaryTransport = ancillaryTransport;
    }

    public UsageOfAncillaryTransport(String name, String description, LocalDate dateUsed, AncillaryTransport ancillaryTransport) {
        this.name = name;
        this.description = description;
        this.dateUsed = dateUsed;
        this.ancillaryTransport = ancillaryTransport;
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

    public LocalDate getDateUsed() {
        return dateUsed;
    }

    public void setDateUsed(LocalDate dateUsed) {
        this.dateUsed = dateUsed;
    }

    public AncillaryTransport getAncillaryTransport() {
        return ancillaryTransport;
    }

    public void setAncillaryTransport(AncillaryTransport ancillaryTransport) {
        this.ancillaryTransport = ancillaryTransport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsageOfAncillaryTransport that = (UsageOfAncillaryTransport) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
