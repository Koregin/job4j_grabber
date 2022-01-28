package ru.job4j.ood.parking;

import org.junit.Ignore;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
public class ParkingServiceTest {

    private ParkingService testParking = new ParkingService(2, 1);

    @Ignore
    public void whenParkingTwoCarsAndTruck() {
        List<Vehicle> vehicles = List.of(
                new Vehicle("car", "B686AC33", "Volvo XC90"),
                new Vehicle("car", "C712AD33", "BMW X6"),
                new Vehicle(2, "truck", "A555FG", "Газ 66"));
        for (Vehicle vehicle : vehicles) {
            testParking.carRegister(vehicle);
        }
        assertTrue(testParking.getCars().containsAll(vehicles));
    }

    @Ignore
    public void whenParkingTwoTrucks() {
        List<Vehicle> vehicles = List.of(
                new Vehicle(2, "truck", "B686AC33", "Камаз"),
                new Vehicle(2, "truck", "A555FG", "Газ 66"));
        for (Vehicle vehicle : vehicles) {
            testParking.carRegister(vehicle);
        }
        assertTrue(testParking.getCars().containsAll(vehicles));
    }

    @Ignore
    public void whenNoPlaceForCar() {
        List<Vehicle> vehicles = List.of(
                new Vehicle("car", "B686AC33", "Volvo XC90"),
                new Vehicle("car", "C712AD33", "BMW X6"),
                new Vehicle("car", "A555FG", "Москвич 2141"));
        for (Vehicle vehicle : vehicles) {
            testParking.carRegister(vehicle);
        }
        assertFalse(testParking.getCars().containsAll(vehicles));
    }

    @Ignore
    public void whenParkingAndUnparking() {
        Vehicle truck = new Vehicle(2, "truck", "B686AC33", "Камаз");
        testParking.carRegister(truck);
        testParking.carUnregister(truck);
        assertFalse(testParking.getCars().contains(truck));
    }

    @Ignore
    public void whenParkingAndUnparkingAndAgainParking() {
        Vehicle truck1 = new Vehicle(2, "truck", "B686AC33", "Камаз");
        Vehicle truck2 = new Vehicle(2, "truck", "A555FG", "Газ 66");
        testParking.carRegister(truck1);
        testParking.carRegister(truck2);
        testParking.carUnregister(truck2);
        Vehicle car = new Vehicle("car", "B686AC33", "Volvo XC90");
        testParking.carRegister(car);
        assertTrue(testParking.getCars().contains(car));
    }

    @Ignore
    public void whenParkingTwoTrucksAndThenOneTruckLeft() {
        Vehicle truck1 = new Vehicle(2, "truck", "B686AC33", "Камаз");
        Vehicle truck2 = new Vehicle(2, "truck", "A555FG", "Газ 66");
        testParking.carRegister(truck1);
        testParking.carRegister(truck2);
        testParking.carUnregister(truck1);
        Vehicle car = new Vehicle("car", "B686AC33", "Volvo XC90");
        testParking.carRegister(car);
        assertFalse(testParking.getCars().contains(car));
    }
}