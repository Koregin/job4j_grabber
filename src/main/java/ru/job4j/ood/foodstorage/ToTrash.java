package ru.job4j.ood.foodstorage;

public class ToTrash implements FoodStrategy {
    Trash trash;

    public ToTrash(Trash trash) {
        this.trash = trash;
    }

    @Override
    public void redistribute(Food food) {
        trash.add(food);
    }
}
