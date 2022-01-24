package ru.job4j.ood.lsp;

/*
В данном примере происходит попытка наследовать класс Аuto подклассом который нельзя использовать как базовый класс
Из за этого методы базового класса и подкласса отличаются.
 */

public class ExampleLSP3 {
    public static void main(String[] args) {
        Auto audiA6 = new Auto("v6", "black", 4);
        audiA6.setBagaznik();
        Auto ducattiB6 = new Bike("B8", "yellow", 2);
        ducattiB6.setBagaznik();

    }
}

class Auto {
    String engine;
    String color;
    int wheels;
    boolean bagaznik;

    public Auto() {
    }

    public Auto(String engine, String color, int wheels) {
        if (wheels < 4) {
            throw new IllegalArgumentException("It's not enough wheels. It's not a car");
        }
        this.engine = engine;
        this.color = color;
        this.wheels = wheels;
    }

    public void setBagaznik() {
        bagaznik = true;
        System.out.println("У меня теперь есть багажник!");
    }
}

class Bike extends Auto {

    public Bike(String engine, String color, int wheels) {
        this.engine = engine;
        this.color = color;
        this.wheels = wheels;
    }

    @Override
    public void setBagaznik() {
        System.out.println("Багажник нельзя поставить на мотоцикл!");
    }
}
