package ru.job4j.foodstore.chain;

import ru.job4j.foodstore.Food;
import ru.job4j.foodstore.stores.Reproduct;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReproductChain implements Chain {
    protected final Reproduct reproduct;
    protected Chain next;
    protected Calendar calendar;

    public ReproductChain(Reproduct reproduct) {
        this.reproduct = reproduct;
        this.calendar = new GregorianCalendar();
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.next = nextChain;
    }

    @Override
    public Chain getNextChain() {
        return this.next;
    }

    @Override
    public void process(Food food) {
        if (shelfLife(food, calendar) >= 100 && food.canReproduct()) {
            this.reproduct.add(food);
        } else {
            this.next.process(food);
        }
    }

    @Override
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
