package edu.nick.cursach.form;

public class StorageObjForm {

    private String type;
    private int area;
    private int number;
    private int capacity;
    private String chief;

    public StorageObjForm() {
    }

    public StorageObjForm(String type, int area, int number, int capacity, String chief) {
        this.type = type;
        this.area = area;
        this.number = number;
        this.capacity = capacity;
        this.chief = chief;
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

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    @Override
    public String toString() {
        return "StorageObjForm{" +
                "type='" + type + '\'' +
                ", area=" + area +
                ", number=" + number +
                ", capacity=" + capacity +
                ", chief=" + chief +
                '}';
    }
}
