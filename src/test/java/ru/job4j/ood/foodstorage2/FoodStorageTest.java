package ru.job4j.ood.foodstorage2;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import static org.junit.Assert.*;

public class FoodStorageTest {

    Warehouse warehouse = new Warehouse();
    Shop shop = new Shop();
    Trash trash = new Trash();
    ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));

    @Test
    public void when25percentExpired() {
        Food food = new Food("avocado", LocalDateTime.now().minusDays(4), LocalDateTime.now().plusDays(14), 320.0, 0.0);
        controlQuality.executeQuality(food);
        assertTrue(warehouse.getWarehouse().contains(food));
    }

    @Test
    public void whenFoodExpiredBetween25and75percent() {
        Food food = new Food("orange", LocalDateTime.now().minusDays(7), LocalDateTime.now().plusDays(7), 130.0, 0.0);
        controlQuality.executeQuality(food);
        assertTrue(shop.getShop().contains(food));
    }

    @Test
    public void whenFoodExpiredMoreThen75percent() {
        LocalDateTime createDate = LocalDateTime.now().minusDays(10);
        LocalDateTime expiredDate = LocalDateTime.now().plusDays(2);
        Food food = new Food("banana", createDate, expiredDate, 70.0, 0.0);
        Food foodAfterDiscount = new Food("banana", createDate, expiredDate, 35.0, 50.0);
        controlQuality.executeQuality(food);
        assertTrue(shop.getShop().contains(foodAfterDiscount));
    }

    @Test
    public void whenFoodIsExpired() {
        Food food = new Food("apple", LocalDateTime.now().minusDays(14), LocalDateTime.now().minusDays(1), 120.0, 0.0);
        controlQuality.executeQuality(food);
        assertTrue(trash.getTrash().contains(food));
    }
}