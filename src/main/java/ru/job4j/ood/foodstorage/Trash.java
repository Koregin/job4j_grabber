package ru.job4j.ood.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Trash {
    List<Food> trash = new ArrayList<>();

    public void add(Food food) {
        trash.add(food);
    }
}
