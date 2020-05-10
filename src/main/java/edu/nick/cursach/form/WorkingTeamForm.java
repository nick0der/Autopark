package edu.nick.cursach.form;

public class WorkingTeamForm {

    private int number;
    private String teamLeader;

    public WorkingTeamForm() {
    }

    public WorkingTeamForm(int number, String teamLeader) {
        this.number = number;
        this.teamLeader = teamLeader;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    @Override
    public String toString() {
        return "WorkingTeamForm{" +
                "number=" + number +
                ", teamLeader=" + teamLeader +
                '}';
    }
}
