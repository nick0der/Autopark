package edu.nick.cursach.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Taxi extends Transport {

    private int seatingCapacity;
    private String bodyType;

    public Taxi() {
    }

    public Taxi(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber, int seatingCapacity, String bodyType) {
        super(id, name, description, dateCreated, dateModified, brand, storageObj, trackNumber);
        this.seatingCapacity = seatingCapacity;
        this.bodyType = bodyType;
    }

    public Taxi(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber, int seatingCapacity, String bodyType) {
        super(name, description, dateCreated, dateModified, brand, storageObj, trackNumber);
        this.seatingCapacity = seatingCapacity;
        this.bodyType = bodyType;
    }

    public Taxi(String name, String description, String brand, StorageObj storageObj, int trackNumber, int seatingCapacity, String bodyType) {
        super(name, description, brand, storageObj, trackNumber);
        this.seatingCapacity = seatingCapacity;
        this.bodyType = bodyType;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
}
