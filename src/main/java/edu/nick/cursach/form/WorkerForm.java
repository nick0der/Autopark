package edu.nick.cursach.form;

public class WorkerForm {

    private String speciality;
    private String firstName;
    private String lastName;
    private String patronymic;
    private int salary;
    private int experience;
    private String workingTeam;

    public WorkerForm() {
    }

    public WorkerForm(String speciality, String firstName, String lastName, String patronymic, int salary, int experience, String workingTeam) {
        this.speciality = speciality;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.salary = salary;
        this.experience = experience;
        this.workingTeam = workingTeam;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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

    public String getWorkingTeam() {
        return workingTeam;
    }

    public void setWorkingTeam(String workingTeam) {
        this.workingTeam = workingTeam;
    }

    @Override
    public String toString() {
        return "WorkerForm{" +
                "speciality='" + speciality + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                ", workingTeam=" + workingTeam +
                '}';
    }
}
