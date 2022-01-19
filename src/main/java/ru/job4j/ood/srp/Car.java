package ru.job4j.ood.srp;

import java.util.List;

/*
 В классе содержаться поля и методы которые выполняют разные цели.
 1. Описывается автомобиль
 2. Сколько продано автомобилей
 3. Кто покупал этот автомобиль. Список покупателей.
 Для соблюдения принципа SRP необходимо разделить этот класс на классы
 Car, Buyers и Sales
*/
public abstract class Car {
    private String engine;
    private String color;
    private String model;

    private int soldOnce;
    private List<String> buyers;

    public String getModel() {
        return null;
    }

    public String getColor() {
        return null;
    }

    public int howManySold(String model) {
        return 0;
    }

    public List<String> whoBoughtThisCar() {
        return null;
    }
}
