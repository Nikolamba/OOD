package ru.job4j.foodstore.chain;

import ru.job4j.foodstore.Food;
import ru.job4j.foodstore.stores.Trash;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrashChain implements Chain {
    protected final Trash trash;
    protected Chain next;
    protected Calendar calendar;

    public TrashChain(Trash trash) {
        this.trash = trash;
        this.calendar = new GregorianCalendar();
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.next = nextChain;
    }

    @Override
    public void process(Food food) {
        if (shelfLife(food, calendar) >= 100) {
            this.trash.add(food);
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
