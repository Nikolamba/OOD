package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.FoodInterface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Абстарктный класс, реализующий общий функционал хранилища
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public abstract class AbstractStore implements Store {
    protected final ArrayList<FoodInterface> heap;
    protected Calendar calendar;

    public AbstractStore() {
        this.heap = new ArrayList<>();
        this.calendar = new GregorianCalendar();
    }

    @Override
    public List<FoodInterface> getHeap() {
        return this.heap;
    }

    @Override
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
