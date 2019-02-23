package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.Food;

public class Trash extends AbstractStore {
    protected int maxSize;

    public Trash() {
        this.maxSize = Integer.MAX_VALUE;
    }

    public Trash(int maxSize) {
        this.maxSize = maxSize;
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
