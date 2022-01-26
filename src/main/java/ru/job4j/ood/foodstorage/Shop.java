package ru.job4j.ood.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    List<Food> shop = new ArrayList<>();

    public void add(Food food) {
        shop.add(food);
    }
}
