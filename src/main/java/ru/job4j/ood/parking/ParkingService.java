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
        boolean result = false;
        if (vehicle.getSize() == Car.CAR && carSpaces > 0) {
            vehicles.add(vehicle);
            carSpaces--;
            result = true;
        } else if (vehicle.getSize() != Car.CAR) {
            if (truckSpaces > 0) {
                vehicles.add(vehicle);
                truckSpaces--;
                result = true;
            } else if (carSpaces >= vehicle.getSize()) {
                    vehicles.add(vehicle);
                    carSpaces -= vehicle.getSize();
                    Truck truck = (Truck) vehicle;
                    truck.setTruckOnCarPlace();
                    result = true;
                }
        }
        return result;
    }

    @Override
    public void carUnregister(Vehicle vehicle) {
        vehicles.remove(vehicle);
        if (vehicle.getSize() != Car.CAR) {
            Truck truck = (Truck) vehicle;
            if (!truck.isTruckOnCarPlace()) {
                truckSpaces++;
            } else {
                carSpaces += vehicle.getSize();
            }
        } else {
            carSpaces++;
        }
    }
}
