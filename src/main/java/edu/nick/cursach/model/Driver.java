package edu.nick.cursach.model;

//import sun.rmi.transport.Transport;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Driver {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String firstName;
    private String lastName;
    private String patronymic;
    private Transport transport;
    private int salary;
    private int experience;

    public Driver() {
    }

    public Driver(String id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String firstName, String lastName, String patronymic, Transport transport, int salary, int experience) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.transport = transport;
        this.salary = salary;
        this.experience = experience;
    }

    public Driver(String name, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String firstName, String lastName, String patronymic, Transport transport, int salary, int experience) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.transport = transport;
        this.salary = salary;
        this.experience = experience;
    }

    public Driver(String name, String description, String firstName, String lastName, String patronymic, Transport transport, int salary, int experience) {
        this.name = name;
        this.description = description;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.transport = transport;
        this.salary = salary;
        this.experience = experience;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id.equals(driver.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
