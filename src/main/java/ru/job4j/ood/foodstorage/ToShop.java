package ru.job4j.ood.foodstorage;

public class ToShop implements FoodStrategy {
    Shop shop;

    public ToShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void redistribute(Food food) {
        shop.add(food);
    }
}
