package ru.job4j.ood.lsp;

/*
В наследуемом подклассе в методе canGraduated, меняется условие, которое влияет на результат работы метода
и изменяет поведение метода в базовом классе.
 */

public class ExampleLSP1 {
    public static void main(String[] args) {
        Student student = new MguStudent("Vasya", "economy", 4);
        if (student.canGraduated()) {
            System.out.println("Студент " + student.name + " может закончить обучение");
        } else {
            System.out.println("Студент " + student.name + " должен ещё поучиться");
        }
    }
}

class Student {
    String name;
    String faculty;
    int course;

    public Student(String name, String faculty, int course) {
        this.name = name;
        this.faculty = faculty;
        this.course = course;
    }

    public boolean canGraduated() {
        boolean result = false;
        if (course > 3) {
            result = true;
        }
        return result;
    }
}

class MguStudent extends Student {

    public MguStudent(String name, String faculty, int course) {
        super(name, faculty, course);
    }

    @Override
    public boolean canGraduated() {
        boolean result = false;
        if (course > 5) {
            result = true;
        }
        return result;
    }
}