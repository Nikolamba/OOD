package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {
    protected int maxSize;
    protected List<Food> coldStorage;

    public Warehouse() {
        this.maxSize = Integer.MAX_VALUE;
        this.coldStorage = new ArrayList<>();
    }

    public Warehouse(int maxSize) {
        this.maxSize = maxSize;
        this.coldStorage = new ArrayList<>();
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override
    public void add(Food food) {
        if ((heap.size() + coldStorage.size()) < maxSize) {
            if (food.isVegetable()) {
                coldStorage.add(food);
            } else {
                heap.add(food);
            }
        }
    }

    public List<Food> getColdStorage() {
        return coldStorage;
    }
}
