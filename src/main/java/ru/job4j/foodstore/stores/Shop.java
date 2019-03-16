package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.FoodInterface;

/**
 * Класс хранилища - магазин
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class Shop extends AbstractStore {

    @Override
    public boolean process(FoodInterface food) {
        if (shelfLife(food, calendar) >= 25 && shelfLife(food, calendar) <= 75) {
            this.heap.add(food);
            return true;
        } else if (shelfLife(food, calendar) > 75 && shelfLife(food, calendar) < 100) {
            food.setDiscount(20);
            this.heap.add(food);
            return true;
        } else {
            return false;
        }
    }
}
