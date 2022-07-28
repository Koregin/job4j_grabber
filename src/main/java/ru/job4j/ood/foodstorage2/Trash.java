package ru.job4j.ood.foodstorage2;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> trash = new ArrayList<>();

    @Override
    public List<Food> getStore() {
        return new ArrayList<>(trash);
    }

    @Override
    public boolean add(Food food) {
        return trash.add(food);
    }

    @Override
    public void clear() {
        trash.clear();
    }
    @Override
    public boolean accept(Food food) {
        return getPercent(food) >= 100;
    }
}
