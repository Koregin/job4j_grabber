package ru.job4j.ood.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingService implements Parking {
    private List<Vehicle> vehicles = new ArrayList<>();
    private int carSpaces;
    private int truckSpaces;

    public ParkingService(int carSpaces, int truckSpaces) {
        this.carSpaces = carSpaces;
        this.truckSpaces = truckSpaces;
    }

    public List<Vehicle> getCars() {
        return new ArrayList<>(vehicles);
    }

    @Override
    public boolean carRegister(Vehicle vehicle) {
        return false;
    }

    @Override
    public void carUnregister(Vehicle vehicle) {

    }
}
