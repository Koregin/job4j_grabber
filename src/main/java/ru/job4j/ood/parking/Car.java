package ru.job4j.ood.parking;

public class Car implements Vehicle {
    public static final int CAR = 1;
    private int size;
    private String number;
    private String model;

    public Car(String number, String model) {
        this.number = number;
        this.model = model;
        this.size = CAR;
    }

    @Override
    public int getSize() {
        return CAR;
    }
}
