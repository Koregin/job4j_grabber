package ru.job4j.ood.isp.menu;

import java.util.*;

public class MenuDemo {
    public static void main(String[] args) {
        Task task1 = new Task("Задача 1");
        Task task1dot1 = new Task("Задача 1.1");
        Task task1dot1dot1 = new Task("Задача 1.1.1");
        Task task1dot1dot2 = new Task("Задача 1.1.2");
        Task task1dot2 = new Task("Задача 1.2");
        SimpleMenu menu = new SimpleMenu(task1);
        menu.add(task1, task1dot1);
        menu.add(task1dot1, task1dot1dot1);
        menu.add(task1dot1, task1dot1dot2);
        menu.add(task1, task1dot2);

        boolean run = true;
        while (run) {
            System.out.println("***** Меню программы *****");
            showMenu(menu, task1);
            Scanner scanner = new Scanner(System.in);
            System.out.println(System.lineSeparator() + "Введите действие или exit для выхода: ");
            String item = scanner.nextLine();
            if ("exit".equals(item)) {
                run = false;
                System.out.println("******* Выход из программы *******");
            } else {
                menu.findBy(item).ifPresentOrElse(node -> node.getValue().doAction(),
                        () -> System.out.println("Ошибка: Неверный пункт меню"));
            }
        }
    }

    private static void showMenu(Menu menu, Task rootTask) {
        Optional<Node<Task>> root = menu.findBy(rootTask.getTaskName());
        root.ifPresent(node -> nodeIterate(node, 0));
    }

    public static void nodeIterate(Node<Task> node, int depth) {
        System.out.print("-".repeat(Math.max(0, depth)));
        System.out.println(" " + node.getValue().getTaskName());
        var children = node.children;
        for (Node<Task> child : children) {
            nodeIterate(child, depth + 4);
        }
    }
}