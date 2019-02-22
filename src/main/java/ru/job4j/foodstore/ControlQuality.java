package ru.job4j.foodstore;

import ru.job4j.foodstore.chain.*;
import ru.job4j.foodstore.stores.Shop;
import ru.job4j.foodstore.stores.Trash;
import ru.job4j.foodstore.stores.Warehouse;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControlQuality {
    protected final Chain c1;
    protected final Shop shop;
    protected final Warehouse warehouse;
    protected final Trash trash;
    protected final Calendar calendar;

    public ControlQuality() {
        this.shop = new Shop();
        this.warehouse = new Warehouse();
        this.trash = new Trash();
        this.calendar = new GregorianCalendar();
        this.c1 = new WarehouseChain(warehouse);
        Chain c2 = new ShopChain(shop);
        Chain c3 = new TrashChain(trash);
        c1.setNextChain(c2);
        c2.setNextChain(c3);
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
