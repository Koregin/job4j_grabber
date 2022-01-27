package ru.job4j.ood.foodstorage2;

import java.time.LocalDateTime;

public interface Percent {
    default double getPercent(Food food) {
        long storageTimeInMinutes = java.time.Duration.between(food.getCreateDate(), food.getExpiryDate()).toMinutes();
        long passedTimeInMinutes = java.time.Duration.between(food.getCreateDate(), LocalDateTime.now()).toMinutes();
        return ((double) passedTimeInMinutes / storageTimeInMinutes) * 100;
    }
}
