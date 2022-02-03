package ru.job4j.ood.foodstorage2;

import java.time.LocalDateTime;
import java.util.List;

public interface Store {
    default double getPercent(Food food) {
        long storageTimeInMinutes = java.time.Duration.between(food.getCreateDate(), food.getExpiryDate()).toMinutes();
        long passedTimeInMinutes = java.time.Duration.between(food.getCreateDate(), LocalDateTime.now()).toMinutes();
        return ((double) passedTimeInMinutes / storageTimeInMinutes) * 100;
    }

    boolean add(Food food);

    boolean removeAll();

    boolean accept(Food food);

    List<Food> getStore();

}
