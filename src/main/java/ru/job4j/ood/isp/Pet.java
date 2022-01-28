package ru.job4j.ood.isp;

/*
В данном примере реализуется интерфейс домашнего питомца с 3-мя методами.
В первом классе реализуется кошка, где используются все три метода.
Во втором классе реализуется кошка-робот, где реализуется только один метод sound().
 */

public interface Pet {
    void eat();
    void sleep();
    void sound();
}

class Cat implements Pet {

    @Override
    public void eat() {
        System.out.println("I'am eating");
    }

    @Override
    public void sleep() {
        System.out.println("Zzzzzz");
    }

    @Override
    public void sound() {
        System.out.println("Мяу");
    }
}

class RoboCat implements Pet {

    @Override
    public void eat() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sleep() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sound() {
        System.out.println("I'm a RoboCat. I don't need any food");
    }
}