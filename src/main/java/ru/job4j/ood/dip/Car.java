package ru.job4j.ood.dip;

/*
В данном примере класс Car использует класс Engine. Класс Engine поддерживает два типа двигателя - бензиновый и дизельный.
Если понадобиться добавить новый тип двигателя, то необходимо будет изменить класс Engine.
Лучше использовать абстракцию в виде интерфейса Engine, реализации которого будут учитывать все особенности определенного типа двигателей.
 */

public class Car {
    private String name;
    private Engine engine;

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Car audiA8 = new Car("AudiA8", new Engine("A8", 200, "бензиновый"));
        System.out.println("Топливо для " + audiA8.getName() + " " + audiA8.getEngine().getFuel());
        Car tesla = new Car("Model S", new Engine("S10", 500, "электрический"));
        System.out.println("Топливо для " + tesla.getName() + " " + tesla.getEngine().getFuel()); /* Выпадет исключение потому что нет типа "электрический" */
    }
}

class Engine {
    private String name;
    private int power;
    private String type;
    private String fuel;

    public Engine(String name, int power, String type) {
        this.name = name;
        this.power = power;
        this.type = type;
        if (type.equals("бензиновый")) {
            this.fuel = "бензин";
        } else if (type.equals("дизельный")) {
            this.fuel = "солярка";
        } else {
            throw new IllegalArgumentException("Неверно указан тип двигателя");
        }
    }

    public String getFuel() {
        return fuel;
    }
}