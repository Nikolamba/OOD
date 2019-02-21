package ru.job4j.foodstore;

import ru.job4j.foodstore.chain.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ControlQuality {
    private final Chain c1;
    private final Shop shop;
    private final Warehouse warehouse;
    private final Trash trash;
    private final Calendar calendar;

    public ControlQuality() {
        this.shop = new Shop(5);
        this.warehouse = new Warehouse(10);
        this.trash = new Trash();
        this.calendar = new GregorianCalendar();
        this.c1 = new WarehouseChain(warehouse);
        Chain c2 = new ShopChain(shop);
        Chain c3 = new ShopChainWithDiscount(shop, 20);
        Chain c4 = new TrashChain(trash);
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
    }

    public ControlQuality(Calendar calendar) {
        this();
        Chain curChain = c1;
        do {
            curChain.setCalendar(calendar);
            curChain = curChain.getNextChain();
        } while (curChain != null);
    }

    public void execute(Food food) {
        this.c1.process(food);
    }

    public Shop getShop() {
        return shop;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Trash getTrash() {
        return trash;
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
