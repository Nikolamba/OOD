package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.Food;

import java.util.ArrayList;
import java.util.List;

public interface Store {
    void add(Food food);
    List<Food> getHeap();
    int getMaxSize();
}
