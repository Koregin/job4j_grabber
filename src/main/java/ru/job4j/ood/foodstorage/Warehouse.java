package ru.job4j.ood.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<Food> warehouse = new ArrayList<>();

    public void add(Food food) {
        warehouse.add(food);
    }
}
