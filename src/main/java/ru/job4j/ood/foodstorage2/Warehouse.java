package ru.job4j.ood.foodstorage2;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store, Percent {
    List<Food> warehouse = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return warehouse.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return getPercent(food) < 25;
    }
}
