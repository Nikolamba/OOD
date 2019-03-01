package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.Food;

public class Warehouse extends AbstractStore {

    @Override
    public boolean process(Food food) {
        if (shelfLife(food, calendar) < 25) {
            this.heap.add(food);
            return true;
        } else {
            return false;
        }
    }
}
