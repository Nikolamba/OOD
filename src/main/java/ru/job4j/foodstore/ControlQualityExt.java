package ru.job4j.foodstore;

import ru.job4j.foodstore.chain.*;
import ru.job4j.foodstore.stores.Reproduct;
import ru.job4j.foodstore.stores.Warehouse;

import java.util.Calendar;

public class ControlQualityExt extends ControlQuality {

    protected Warehouse warehouse2;
    protected Reproduct reproduct;

    public ControlQualityExt() {
        warehouse = new Warehouse(3);
        this.warehouse2 = new Warehouse();
        this.reproduct = new Reproduct();
        c1 = new WarehouseChainExt(warehouse);
        Chain c2 = new WarehouseChainExt(warehouse2);
        Chain c3 = new ShopChain(shop);
        Chain c4 = new TrashChainExt(trash);
        Chain c5 = new ReproductChain(reproduct);
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
        c4.setNextChain(c5);
    }

    public ControlQualityExt(Calendar calendar) {
        this();
        Chain curChain = c1;
        do {
            curChain.setCalendar(calendar);
            curChain = curChain.getNextChain();
        } while (curChain != null);
    }

    public Warehouse getWarehouse2() {
        return warehouse2;
    }

    public Reproduct getReproduct() {
        return reproduct;
    }
}
