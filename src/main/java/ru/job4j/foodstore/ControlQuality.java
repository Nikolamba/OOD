package ru.job4j.foodstore;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ControlQuality {
    protected Store warehouse;
    protected Store shop;
    protected Store trash;
    protected Calendar calendar;

    public ControlQuality() {
        this.warehouse = new Warehouse(2);
        this.shop = new Shop(2);
        this.trash = new Trash();
        calendar = new GregorianCalendar();
    }

    public void execute(Food food) {
        Store currentStore;
        int shelfLife = shelfLife(food);
        if (shelfLife < 0 || shelfLife > 100) {
            throw new IllegalStateException("error of the current date or date in the product");
        }
        if (shelfLife < 25) {
            currentStore = warehouse;
        } else if (shelfLife < 75) {
            currentStore = shop;
        } else if (shelfLife < 100) {
            food.setDiscount(20);
            currentStore = shop;
        } else {
            currentStore = trash;
        }
        currentStore.add(food);
    }

    public int shelfLife(Food food) {
        long shelfLife = food.getExpareDate().getTime() - food.getCreateDate().getTime();
        long after = calendar.getTime().getTime() - food.getCreateDate().getTime();
        System.out.println((int) ((after * 100) / shelfLife));
        return  (int) ((after * 100) / shelfLife);
    }

    public Store getWarehouse() {
        return warehouse;
    }

    public Store getShop() {
        return shop;
    }

    public Store getTrash() {
        return trash;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setWarehouse(Store warehouse) {
        this.warehouse = warehouse;
    }

    public void setShop(Store shop) {
        this.shop = shop;
    }

    public void setTrash(Store trash) {
        this.trash = trash;
    }

    public static void main(String[] args) {
        ControlQuality control = new ControlQuality();
        Date expireDate = new GregorianCalendar(2019, GregorianCalendar.MARCH, 15).getTime();
        Date createDate = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 1).getTime();
        Food food1 = new Food("Milk", expireDate, createDate, 44);

        control.execute(food1);

        System.out.println("WAREHOUSE");
        for (Food food : control.warehouse.getHeap()) {
            System.out.println(food);
        }
        System.out.println("SHOP");
        for (Food food : control.shop.getHeap()) {
            System.out.println(food);
        }
        System.out.println("TRASH");
        for (Food food : control.trash.getHeap()) {
            System.out.println(food);
        }
    }
}
