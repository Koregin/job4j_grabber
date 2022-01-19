package ru.job4j.ood.srp;

import java.util.List;

/*
В этом интерфейсе выполняются две задачи
1. Создание блюда
2. Печать меню
Это расходится с принципом SRP. Одна сущность должна выполнять одну задачу
В этом примере решается две задачи.
 */
public interface Dish<T, V> {
    T createdish(T dish);
    void printDishesMenu(List<V> dishes);
}
