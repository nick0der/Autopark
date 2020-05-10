package edu.nick.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class StorageObj {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String type;
    private int area;
    private int number;
    private int capacity;
    private Chief chief;

    public StorageObj() {
    }

    public StorageObj(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String type, int area, int number, int capacity, Chief chief) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.type = type;
        this.area = area;
        this.number = number;
        this.capacity = capacity;
        this.chief = chief;
    }

    public StorageObj(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String type, int area, int number, int capacity, Chief chief) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.type = type;
        this.area = area;
        this.number = number;
        this.capacity = capacity;
        this.chief = chief;
    }

    public StorageObj(String name, String description, String type, int area, int number, int capacity, Chief chief) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.area = area;
        this.number = number;
        this.capacity = capacity;
        this.chief = chief;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Chief getChief() { return chief; }

    public void setChief(Chief chief) { this.chief = chief; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageObj that = (StorageObj) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
