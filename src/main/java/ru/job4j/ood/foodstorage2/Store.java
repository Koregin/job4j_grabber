package ru.job4j.ood.foodstorage2;

public interface Store {
    boolean add(Food food);
    boolean accept(Food food);
}
