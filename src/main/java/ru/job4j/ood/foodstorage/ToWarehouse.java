package ru.job4j.ood.foodstorage;

public class ToWarehouse implements FoodStrategy {
    Warehouse warehouse;

    public ToWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void redistribute(Food food) {
        warehouse.add(food);
    }
}
