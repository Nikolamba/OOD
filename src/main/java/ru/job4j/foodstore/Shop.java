package ru.job4j.foodstore;

import java.util.ArrayList;

public class Shop implements Store {
    protected final ArrayList<Food> heap;
    protected int maxSize;

    public Shop(int maxSize) {
        this.heap = new ArrayList<>();
        this.maxSize = maxSize;
    }

    @Override
    public void add(Food food) {
        this.heap.add(food);
    }

    @Override
    public ArrayList<Food> getHeap() {
        return heap;
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }
}
