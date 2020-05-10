package edu.nick.cursach.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class AncillaryTransport extends Transport {

    private String mission;

    public AncillaryTransport() {
    }

    public AncillaryTransport(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber, String mission) {
        super(id, name, description, dateCreated, dateModified, brand, storageObj, trackNumber);
        this.mission = mission;
    }

    public AncillaryTransport(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber, String mission) {
        super(name, description, dateCreated, dateModified, brand, storageObj, trackNumber);
        this.mission = mission;
    }

    public AncillaryTransport(String name, String description, String brand, StorageObj storageObj, int trackNumber, String mission) {
        super(name, description, brand, storageObj, trackNumber);
        this.mission = mission;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
