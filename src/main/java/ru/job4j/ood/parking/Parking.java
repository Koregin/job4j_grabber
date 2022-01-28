package ru.job4j.ood.parking;

public interface Parking {
    boolean carRegister(Vehicle vehicle);
    void carUnregister(Vehicle vehicle);
}
