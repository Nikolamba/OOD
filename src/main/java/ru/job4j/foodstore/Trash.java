package ru.job4j.foodstore;

import java.util.ArrayList;

public class Trash implements Store {
    protected final ArrayList<Food> heap;
    protected int maxSize;

    public Trash() {
        this.heap = new ArrayList<>();
        this.maxSize = -1;
    }

    @Override
    public void add(Food food) {
        this.heap.add(food);
    }

    public ArrayList<Food> getHeap() {
        return heap;
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }
}
