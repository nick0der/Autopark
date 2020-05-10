package edu.nick.cursach.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class RouteTaxi extends Transport {

    private int seatingCapacity;
    private int number;
    private Route route;

    public RouteTaxi() {
    }

    public RouteTaxi(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber, int seatingCapacity, int number, Route route) {
        super(id, name, description, dateCreated, dateModified, brand, storageObj, trackNumber);
        this.seatingCapacity = seatingCapacity;
        this.number = number;
        this.route = route;
    }

    public RouteTaxi(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber, int seatingCapacity, int number, Route route) {
        super(name, description, dateCreated, dateModified, brand, storageObj, trackNumber);
        this.seatingCapacity = seatingCapacity;
        this.number = number;
        this.route = route;
    }

    public RouteTaxi(String name, String description, String brand, StorageObj storageObj, int trackNumber, int seatingCapacity, int number, Route route) {
        super(name, description, brand, storageObj, trackNumber);
        this.seatingCapacity = seatingCapacity;
        this.number = number;
        this.route = route;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
