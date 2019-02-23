package ru.job4j.foodstore.chain;

import ru.job4j.foodstore.Food;
import ru.job4j.foodstore.stores.Warehouse;

import java.util.Calendar;

public class WarehouseChainExt extends WarehouseChain {

    public WarehouseChainExt(Warehouse warehouse) {
        super(warehouse);
    }

    @Override
    public void process(Food food) {
        if (shelfLife(food, calendar) < 25 && (warehouse.getHeap().size() < warehouse.getMaxSize())) {
            this.warehouse.add(food);
        } else {
            this.next.process(food);
        }
    }
}
