package ru.job4j.foodstore;

import java.util.ArrayList;
import java.util.List;

public interface Store {
    void add(Food food);
    List<Food> getHeap();
    int getMaxSize();
}
