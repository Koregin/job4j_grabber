package ru.job4j.ood.dip;

/*
В данном примере методы класса реализуются в самом классе.
Если необходимо будет добавить или изменить метод, то надо будет добавлять новый метод в класс
Лучше создать абстракцию в виде интерфейса определяющего один метод, который будет переопределятся в зависимости от реализации.
 */

public class Calculator {
    double aDouble;
    double bDouble;

    public Calculator(double aDouble, double bDouble) {
        this.aDouble = aDouble;
        this.bDouble = bDouble;
    }

    public double add() {
        return aDouble + bDouble;
    }

    public double substr() {
        return  aDouble - bDouble;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator(5, 5);
        System.out.println(calc.add());
        System.out.println(calc.substr());
    }
}
