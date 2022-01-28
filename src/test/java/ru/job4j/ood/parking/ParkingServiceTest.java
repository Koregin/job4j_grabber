package ru.job4j.ood.parking;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class ParkingServiceTest {

    private ParkingService testParking = new ParkingService(2, 1);

    @Test
    public void whenParkingTwoCarsAndTruck() {
        List<Vehicle> vehicles = List.of(
                new Car("B686AC33", "Volvo XC90"),
                new Car("C712AD33", "BMW X6"),
                new Truck(2, "A555FG", "Газ 66"));
        for (Vehicle vehicle : vehicles) {
            testParking.carRegister(vehicle);
        }
        assertTrue(testParking.getCars().containsAll(vehicles));
    }

    @Test
    public void whenParkingTwoTrucks() {
        List<Vehicle> vehicles = List.of(
                new Truck(3, "B686AC33", "Камаз"),
                new Truck(2, "A555FG", "Газ 66"));
        for (Vehicle vehicle : vehicles) {
            testParking.carRegister(vehicle);
        }
        assertTrue(testParking.getCars().containsAll(vehicles));
    }

    @Test
    public void whenNoPlaceForCar() {
        List<Vehicle> vehicles = List.of(
                new Car("B686AC33", "Volvo XC90"),
                new Car("C712AD33", "BMW X6"),
                new Car("A555FG", "Москвич 2141"));
        for (Vehicle vehicle : vehicles) {
            testParking.carRegister(vehicle);
        }
        assertFalse(testParking.getCars().containsAll(vehicles));
    }

    @Test
    public void whenParkingAndUnparking() {
        Vehicle truck = new Truck(3, "B686AC33", "Камаз");
        testParking.carRegister(truck);
        testParking.carUnregister(truck);
        assertFalse(testParking.getCars().contains(truck));
    }

    @Test
    public void whenParkingAndUnparkingAndAgainParking() {
        Vehicle truck1 = new Truck(3, "B686AC33", "Камаз");
        Vehicle truck2 = new Truck(2, "A555FG", "Газ 66");
        testParking.carRegister(truck1);
        testParking.carRegister(truck2);
        testParking.carUnregister(truck2);
        Vehicle car = new Car("B686AC33", "Volvo XC90");
        assertTrue(testParking.carRegister(car));
    }

    @Test
    public void whenParkingTwoTrucksAndThenOneTruckLeft() {
        Vehicle truck1 = new Truck(3, "B686AC33", "Камаз");
        Vehicle truck2 = new Truck(2, "A555FG", "Газ 66");
        testParking.carRegister(truck1);
        testParking.carRegister(truck2);
        testParking.carUnregister(truck1);
        Vehicle car = new Car("B686AC33", "Volvo XC90");
        assertFalse(testParking.carRegister(car));
    }

    @Test
    public void whenTruckHasSizeFour() {
        Vehicle belaz = new Truck(4, "B666AC33", "Белаз>");
        assertTrue(testParking.carRegister(belaz));
    }
}