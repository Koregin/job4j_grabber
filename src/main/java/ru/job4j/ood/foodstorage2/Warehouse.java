package ru.job4j.ood.foodstorage2;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private List<Food> warehouse = new ArrayList<>();

    public List<Food> getWarehouse() {
        return warehouse;
    }

    @Override
    public boolean add(Food food) {
        return warehouse.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return getPercent(food) < 25;
    }
}
