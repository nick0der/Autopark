package edu.nick.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class WorkingTeam {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private int number;
    private TeamLeader teamLeader;

    public WorkingTeam() {
    }

    public WorkingTeam(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, int number, TeamLeader teamLeader) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.number = number;
        this.teamLeader = teamLeader;
    }

    public WorkingTeam(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, int number, TeamLeader teamLeader) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.number = number;
        this.teamLeader = teamLeader;
    }

    public WorkingTeam(String name, String description, int number, TeamLeader teamLeader) {
        this.name = name;
        this.description = description;
        this.number = number;
        this.teamLeader = teamLeader;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TeamLeader getTeamLeader() { return teamLeader; }

    public void setTeamLeader(TeamLeader teamLeader) { this.teamLeader = teamLeader; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingTeam that = (WorkingTeam) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
