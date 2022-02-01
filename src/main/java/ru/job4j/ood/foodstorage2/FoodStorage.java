package ru.job4j.ood.foodstorage2;

import java.time.LocalDateTime;
import java.util.List;

public class FoodStorage {

    public static void main(String[] args) {
        List<Food> products = List.of(
                new Food("banana", LocalDateTime.now().minusDays(14), LocalDateTime.now().minusDays(1), 70.0, 0.0),
                new Food("avocado", LocalDateTime.now().minusDays(4), LocalDateTime.now().plusDays(20), 320.0, 0.0),
                new Food("apple", LocalDateTime.now().minusDays(14), LocalDateTime.now().plusDays(15), 120.0, 0.0),
                new Food("orange", LocalDateTime.now().minusDays(14), LocalDateTime.now().plusDays(2), 130.0, 0.0));

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        for (Food food : products) {
            controlQuality.executeQuality(food);
        }
        System.out.println("Товары на складе");
        for (Food food : warehouse.getStore()) {
            System.out.println(food);
        }
        System.out.println("Товары в магазине");
        for (Food food : shop.getStore()) {
            System.out.println(food);
        }
        System.out.println("Товары в мусорке");
        for (Food food : trash.getStore()) {
            System.out.println(food);
        }
    }
}
