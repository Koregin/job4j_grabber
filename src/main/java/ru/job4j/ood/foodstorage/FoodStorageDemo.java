package ru.job4j.ood.foodstorage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FoodStorageDemo {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final LocalDateTime CURRENTTIME = LocalDateTime.parse("2022-01-13 12:35:00", FORMATTER);

    public static LocalDateTime setTime(String datetime) {
        return LocalDateTime.parse(datetime, FORMATTER);
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();

        List<Food> products = List.of(new Food("banana", setTime("2022-01-01 19:00:00"), setTime("2022-01-14 19:00:00"), 70.0, 0.0),
                new Food("avocado", setTime("2022-01-01 19:00:00"), setTime("2022-02-28 19:00:00"), 320.0, 0.0),
                new Food("apple", setTime("2022-01-01 19:00:00"), setTime("2022-01-12 19:00:00"), 120.0, 0.0),
                new Food("orange", setTime("2022-01-01 19:00:00"), setTime("2022-02-10 19:00:00"), 130.0, 0.0));

        ControlQuality control = new ControlQuality(shop, warehouse, trash);
        for (Food food : products) {
            control.executeStrategy(food);
        }
        System.out.println("Товары в магазине");
        for (Food food : shop.shop) {
            System.out.println(food);
        }
        System.out.println("Товары на складе");
        for (Food food : warehouse.warehouse) {
            System.out.println(food);
        }
        System.out.println("Товары в мусорке");
        for (Food food : trash.trash) {
            System.out.println(food);
        }
    }
}
