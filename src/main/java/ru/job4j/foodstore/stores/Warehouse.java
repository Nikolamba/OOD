package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.FoodInterface;

/**
 * Класс хранилища - склад
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class Warehouse extends AbstractStore {

    @Override
    public boolean process(FoodInterface food) {
        if (shelfLife(food, calendar) < 25) {
            this.heap.add(food);
            return true;
        } else {
            return false;
        }
    }
}
