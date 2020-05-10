package edu.nick.cursach.form;

public class DriverForm {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String transport;
    private int salary;
    private int experience;

    public DriverForm() {
    }

    public DriverForm(String firstName, String lastName, String patronymic, String transport, int salary, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.transport = transport;
        this.salary = salary;
        this.experience = experience;
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

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
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
    public String toString() {
        return "DriverForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", transport=" + transport +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }
}
