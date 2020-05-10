package edu.nick.cursach.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class FreightTransport extends Transport {


    private int loadCapacity;
    private String type;

    public FreightTransport() {
    }

    public FreightTransport(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber, int loadCapacity, String type) {
        super(id, name, description, dateCreated, dateModified, brand, storageObj, trackNumber);
        this.loadCapacity = loadCapacity;
        this.type = type;
    }

    public FreightTransport(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber, int loadCapacity, String type) {
        super(name, description, dateCreated, dateModified, brand, storageObj, trackNumber);
        this.loadCapacity = loadCapacity;
        this.type = type;
    }

    public FreightTransport(String name, String description, String brand, StorageObj storageObj, int trackNumber, int loadCapacity, String type) {
        super(name, description, brand, storageObj, trackNumber);
        this.loadCapacity = loadCapacity;
        this.type = type;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
