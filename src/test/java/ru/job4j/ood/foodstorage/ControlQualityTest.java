package ru.job4j.ood.foodstorage;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static ru.job4j.ood.foodstorage.FoodStorageDemo.setTime;

public class ControlQualityTest {

    private Shop shop = new Shop();
    private Warehouse warehouse = new Warehouse();
    private Trash trash = new Trash();
    private ControlQuality control = new ControlQuality(shop, warehouse, trash);

    @Test
    public void when25percentExpired() {
        Food food = new Food("avocado", setTime("2022-01-01 19:00:00"), setTime("2022-02-28 19:00:00"), 320.0, 0.0);
        Warehouse testWarehouse = new Warehouse();
        testWarehouse.add(food);
        control.executeStrategy(food);
        assertThat(warehouse.warehouse.get(0), is(testWarehouse.warehouse.get(0)));
    }

    @Test
    public void whenFoodExpiredBetween25and75percent() {
        Food food = new Food("orange", setTime("2022-01-01 19:00:00"), setTime("2022-02-10 19:00:00"), 130.0, 0.0);
        Shop testShop = new Shop();
        testShop.add(food);
        control.executeStrategy(food);
        assertThat(shop.shop.get(0), is(testShop.shop.get(0)));
    }

    @Test
    public void whenFoodExpiredMoreThen75percent() {
        Food food = new Food("banana", setTime("2022-01-01 19:00:00"), setTime("2022-01-14 19:00:00"), 70.0, 0.0);
        Food foodAfterDiscount = new Food("banana", setTime("2022-01-01 19:00:00"), setTime("2022-01-14 19:00:00"), 35.0, 50.0);
        Shop testShop = new Shop();
        testShop.add(foodAfterDiscount);
        control.executeStrategy(food);
        assertThat(shop.shop.get(0), is(testShop.shop.get(0)));
    }

    @Test
    public void whenFoodIsExpired() {
        Food food = new Food("apple", setTime("2022-01-01 19:00:00"), setTime("2022-01-12 19:00:00"), 120.0, 0.0);
        Trash testTrash = new Trash();
        testTrash.add(food);
        control.executeStrategy(food);
        assertThat(trash.trash.get(0), is(testTrash.trash.get(0)));
    }
}