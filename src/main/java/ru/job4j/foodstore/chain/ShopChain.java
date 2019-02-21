package ru.job4j.foodstore.chain;

import ru.job4j.foodstore.Food;
import ru.job4j.foodstore.Shop;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ShopChain implements Chain {
    protected final Shop shop;
    protected Chain next;
    protected Calendar calendar;

    public ShopChain(Shop shop) {
        this.shop = shop;
        this.calendar = new GregorianCalendar();
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.next = nextChain;
    }

    @Override
    public void process(Food food) {
        if (shelfLife(food, calendar) >= 25 && shelfLife(food, calendar) <= 75) {
            this.shop.add(food);
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
