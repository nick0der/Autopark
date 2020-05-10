package edu.nick.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Route {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String start;
    private String finish;
    private int distance;

    public Route() {
    }

    public Route(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String start, String finish, int distance) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.start = start;
        this.finish = finish;
        this.distance = distance;
    }

    public Route(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String start, String finish, int distance) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.start = start;
        this.finish = finish;
        this.distance = distance;
    }

    public Route(String name, String description, String start, String finish, int distance) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.distance = distance;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id.equals(route.id);
    }

    public String getFullTitle(){
        return start + " - " + finish;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
