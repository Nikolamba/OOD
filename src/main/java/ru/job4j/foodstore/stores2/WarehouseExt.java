package ru.job4j.foodstore.stores2;

import ru.job4j.foodstore.FoodInterface;
import ru.job4j.foodstore.stores.Warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Расширенный класс склад
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class WarehouseExt extends Warehouse {
    protected int maxSize;
    protected int lowTempMaxSize;
    protected final List<FoodInterface> lowTempHeap;

    public WarehouseExt(int maxSize, int lowTempMaxSize) {
        this.maxSize = maxSize;
        this.lowTempMaxSize = lowTempMaxSize;
        this.lowTempHeap = new ArrayList<>();
    }

    @Override
    public boolean process(FoodInterface food) {
        boolean result = false;
        if (shelfLife(food, calendar) < 25 ) {
            if (food.isVegetable()) {
                if (lowTempHeap.size() < lowTempMaxSize) {
                    lowTempHeap.add(food);
                    result = true;
                }
            } else {
                if (heap.size() < maxSize) {
                    heap.add(food);
                    result = true;
                }
            }
        }
        return result;
    }

    public List<FoodInterface> getLowTempStorage() {
        return lowTempHeap;
    }
}
