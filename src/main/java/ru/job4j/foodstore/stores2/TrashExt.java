package ru.job4j.foodstore.stores2;

import ru.job4j.foodstore.FoodInterface;
import ru.job4j.foodstore.stores.Trash;

/**
 * Расширенный класс мусорка
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class TrashExt extends Trash {

    @Override
    public boolean process(FoodInterface food) {
        if (shelfLife(food, calendar) >= 100 && !food.canReproduct()) {
            this.heap.add(food);
            return true;
        } else {
            return false;
        }
    }
}
