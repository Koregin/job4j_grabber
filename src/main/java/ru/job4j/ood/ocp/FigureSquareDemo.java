package ru.job4j.ood.ocp;

import java.util.List;

/*
В этом примере дан класс Rectangle и класс AreasCalc для вычисления площадей массива прямоугольников
Метод totalOfAreas возвращает общую площадь
Если понадобиться вычислять площадь для другой фигуры, то придется изменять класс AreasCalc.
Это нарушает принцип OCP
*/
public class FigureSquareDemo {

    public static class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
    }

    public static class AreasCalc {
        List<Rectangle> shapes;

        public AreasCalc(List<Rectangle> shapes) {
            this.shapes = shapes;
        }

        public double totalOfAreas() {
            double total = 0.0;
            for (Rectangle shape : shapes) {
                total += shape.height * shape.width;
            }
            return total;
        }
    }

    public static void main(String[] args) {
        List<Rectangle> shapes = List.of(new Rectangle(5, 5),
                                            new Rectangle(4, 4),
                                            new Rectangle(3, 3));
        AreasCalc areasCalc = new AreasCalc(shapes);
        System.out.println(areasCalc.totalOfAreas());
    }
}
