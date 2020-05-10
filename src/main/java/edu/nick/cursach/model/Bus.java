package edu.nick.cursach.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Bus extends Transport {


    private int seatingCapacity;
    private String serviceClass;
    private Route route;

    public Bus() {
    }

    public Bus(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber, int seatingCapacity, String serviceClass, Route route) {
        super(id, name, description, dateCreated, dateModified, brand, storageObj, trackNumber);
        this.seatingCapacity = seatingCapacity;
        this.serviceClass = serviceClass;
        this.route = route;
    }

    public Bus(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String brand, StorageObj storageObj, int trackNumber, int seatingCapacity, String serviceClass, Route route) {
        super(name, description, dateCreated, dateModified, brand, storageObj, trackNumber);
        this.seatingCapacity = seatingCapacity;
        this.serviceClass = serviceClass;
        this.route = route;
    }

    public Bus(String name, String description, String brand, StorageObj storageObj, int trackNumber, int seatingCapacity, String serviceClass, Route route) {
        super(name, description, brand, storageObj, trackNumber);
        this.seatingCapacity = seatingCapacity;
        this.serviceClass = serviceClass;
        this.route = route;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "seatingCapacity=" + seatingCapacity +
                ", serviceClass='" + serviceClass + '\'' +
                ", route=" + route +
                '}';
    }
}
