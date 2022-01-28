package ru.job4j.ood.parking;

public class Truck implements Vehicle {
    private int size;
    private String number;
    private String model;
    private boolean truckOnCarPlace = false;

    public Truck(int size, String number, String model) {
        this.size = size;
        if (size < 2) {
            throw new IllegalArgumentException("Wrong size");
        }
        this.number = number;
        this.model = model;
    }

    public void setTruckOnCarPlace() {
        this.truckOnCarPlace = true;
    }

    public boolean isTruckOnCarPlace() {
        return truckOnCarPlace;
    }

    @Override
    public int getSize() {
        return size;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }
}
