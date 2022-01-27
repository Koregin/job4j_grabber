package ru.job4j.ood.foodstorage2;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> trash = new ArrayList<>();

    public List<Food> getTrash() {
        return trash;
    }

    @Override
    public boolean add(Food food) {
        return trash.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return getPercent(food) >= 100;
    }
}
