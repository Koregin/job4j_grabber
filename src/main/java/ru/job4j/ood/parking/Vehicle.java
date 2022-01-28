package ru.job4j.ood.parking;

public class Vehicle {
    private int size = 0;
    private String type;
    private String number;
    private String model;
    private boolean truckOnCarPlace = false;

    public Vehicle(String type, String number, String model) {
        this.type = type;
        this.number = number;
        this.model = model;
    }

    public Vehicle(int size, String type, String number, String model) {
        this.size = size;
        this.type = type;
        this.number = number;
        this.model = model;
    }

    public void setTruckOnCarPlace() {
        this.truckOnCarPlace = true;
    }

    public boolean isTruckOnCarPlace() {
        return truckOnCarPlace;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }
}
