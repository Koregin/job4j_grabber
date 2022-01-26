package ru.job4j.ood.foodstorage;

public class ControlQuality {
    private Shop shop;
    private Warehouse warehouse;
    private Trash trash;

    public ControlQuality(Shop shop, Warehouse warehouse, Trash trash) {
        this.shop = shop;
        this.warehouse = warehouse;
        this.trash = trash;
    }
    /*
        В зависимости от срока годности вызываются нужные стратегии для сортировки продукта
     */
     public void executeStrategy(Food food) {
        FoodStrategy strategy;
        long storageTimeInMinutes = java.time.Duration.between(food.getCreateDate(), food.getExpiryDate()).toMinutes();
        long passedTimeInMinutes = java.time.Duration.between(food.getCreateDate(), FoodStorageDemo.CURRENTTIME).toMinutes();
        double storagePercentage = ((double) passedTimeInMinutes / storageTimeInMinutes) * 100;
        if (storagePercentage <= 25) {
            strategy = new ToWarehouse(warehouse);
        } else if (storagePercentage > 25 && storagePercentage < 75) {
            strategy = new ToShop(shop);
        } else if (storagePercentage > 75 && storagePercentage < 100) {
            food.setDiscount(50);
            strategy = new ToShop(shop);
        } else {
            strategy = new ToTrash(trash);
        }
        strategy.redistribute(food);
     }
}
