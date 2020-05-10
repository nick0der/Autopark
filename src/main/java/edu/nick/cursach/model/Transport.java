package edu.nick.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Transport {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String brand;
    private StorageObj storageObj;
    private int trackNumber;

    public Transport() {
    }

    public Transport(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.brand = brand;
        this.storageObj = storageObj;
        this.trackNumber = trackNumber;
    }

    public Transport(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.brand = brand;
        this.storageObj = storageObj;
        this.trackNumber = trackNumber;
    }

    public Transport(String name, String description, String brand, StorageObj storageObj, int trackNumber) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.storageObj = storageObj;
        this.trackNumber = trackNumber;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public StorageObj getStorageObj() {
        return storageObj;
    }

    public void setStorageObj(StorageObj storageObj) {
        this.storageObj = storageObj;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getBrandAndTrackNumber(){
        return brand + " (" + trackNumber + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return id.equals(transport.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", brand='" + brand + '\'' +
                ", storageObj=" + storageObj +
                ", trackNumber=" + trackNumber +
                '}';
    }
}
