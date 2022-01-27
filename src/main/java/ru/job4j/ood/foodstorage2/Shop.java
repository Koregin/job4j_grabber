package ru.job4j.ood.foodstorage2;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private List<Food> shop = new ArrayList<>();

    public List<Food> getShop() {
        return shop;
    }

    @Override
    public boolean add(Food food) {
        return shop.add(food);
    }

    @Override
    public boolean accept(Food food) {
        double expiredPercent = getPercent(food);
        boolean result = false;
        if (expiredPercent >= 25 && expiredPercent <= 75) {
            result = true;
        } else if (expiredPercent > 75 && expiredPercent < 100) {
            food.setDiscount(50);
            result = true;
        }
        return result;
    }
}
