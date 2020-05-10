package edu.nick.cursach.form;

public class RouteForm {

    private String start;
    private String finish;
    private int distance;

    public RouteForm() {
    }

    public RouteForm(String start, String finish, int distance) {
        this.start = start;
        this.finish = finish;
        this.distance = distance;
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
    public String toString() {
        return "RouteForm{" +
                "start='" + start + '\'' +
                ", finish='" + finish + '\'' +
                ", distance=" + distance +
                '}';
    }
}
