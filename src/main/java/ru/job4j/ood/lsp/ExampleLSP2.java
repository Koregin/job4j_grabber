package ru.job4j.ood.lsp;

/*
В данном примере у наследуемого подкласса ослабляется условие описанное в родительском классе.
Что неправильно, так как нарушает принцип LSP
 */

public class ExampleLSP2 {
    public static void main(String[] args) {
        Toy car = new ToyCar(0);
        car.move(); /* исключение не выдается потому что нет условия в переопределенном методе */
        Toy train = new Toy(5);
        train.move();  /* выдается исключение потому что не проходит условие. POWER < 9*/
    }
}

class Toy {
    static final double ELEMENTPOWER = 1.5;
    int batteries;
    double power;

    public Toy(int batteries) {
        this.batteries = batteries;
        power = ELEMENTPOWER * batteries;
    }

    public void move() {
        if (power < 9) {
            throw new IllegalArgumentException("I need more power");
        }
        System.out.println("My power " + power + " and I am moving");
    }
}

class ToyCar extends Toy {

    public ToyCar(int batteries) {
        super(batteries);
    }

    @Override
    public void move() {
        /* забыто условие */
        System.out.println("My power " + power + " and I am moving");
    }
}