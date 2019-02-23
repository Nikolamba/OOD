package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.Food;

public class Reproduct extends AbstractStore {
    protected int maxSize;

    public Reproduct(int maxSize) {
        this.maxSize = maxSize;
    }

    public Reproduct() {
        this.maxSize = Integer.MAX_VALUE;
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override
    public void add(Food food) {
        if (heap.size() < maxSize) {
            heap.add(food);
        }
    }
}
