package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.Food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected final ArrayList<Food> heap;
    protected Calendar calendar;

    public AbstractStore() {
        this.heap = new ArrayList<>();
        this.calendar = new GregorianCalendar();
    }

    @Override
    public List<Food> getHeap() {
        return this.heap;
    }

    @Override
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
