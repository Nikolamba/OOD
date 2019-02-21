package ru.job4j.foodstore.chain;

import ru.job4j.foodstore.Food;
import ru.job4j.foodstore.Warehouse;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class WarehouseChain implements Chain {
    private final Warehouse warehouse;
    private Chain next;
    private Calendar calendar;

    public WarehouseChain(Warehouse warehouse) {
        this.warehouse = warehouse;
        this.calendar = new GregorianCalendar();
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.next = nextChain;
    }

    @Override
    public void process(Food food) {
        if (shelfLife(food, calendar) < 25) {
            this.warehouse.add(food);
        } else {
            this.next.process(food);
        }
    }

    @Override
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public Chain getNextChain() {
        return next;
    }
}
