package ru.job4j.ood.foodstorage2;

import java.util.List;

public class ControlQuality {
    private List<Store> storages;

    public ControlQuality(List<Store> storage) {
        this.storages = storage;
    }

    public void executeQuality(Food food) {
        for (Store store : storages) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
        }
    }
}
