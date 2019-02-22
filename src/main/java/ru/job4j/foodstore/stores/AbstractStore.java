package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected final ArrayList<Food> heap;

    public AbstractStore() {
        this.heap = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        this.heap.add(food);
    }

    @Override
    public List<Food> getHeap() {
        return this.heap;
    }
}
