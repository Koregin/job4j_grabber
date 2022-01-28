package ru.job4j.ood.isp;

/*
В данном примере реализуется интерфейс Duck
В реализации класса WildDuck используются все 3 метода
В реализации класса RubberDuck не реализован метод fly(), так-как резиновые утки не умеют летать.
 */

public interface Duck {
    void fly();
    void swim();
    void sound();
}

class WildDuck implements Duck {

    @Override
    public void fly() {
        System.out.println("I can fly");
    }

    @Override
    public void swim() {
        System.out.println("I can swim very well");
    }

    @Override
    public void sound() {
        System.out.println("Кря-Кря");
    }
}

class RubberDuck implements Duck {

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void swim() {
        System.out.println("Могу держаться на воде");
    }

    @Override
    public void sound() {
        System.out.println("Пиу-Пиу-Пиу");
    }
}