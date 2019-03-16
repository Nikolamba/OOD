package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.FoodInterface;

import java.util.Calendar;
import java.util.List;

/**
 * Интерфейс, описывающий поведения хранилища
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface Store {
    List<FoodInterface> getHeap();
    boolean process(FoodInterface food);
    void setCalendar(Calendar calendar);

    default int shelfLife(FoodInterface food, Calendar calendar) {
        long shelfLife = food.getExpareDate().getTime() - food.getCreateDate().getTime();
        long after = calendar.getTime().getTime() - food.getCreateDate().getTime();
        //System.out.println((int) Math.ceil((after * 100) / shelfLife));
        return (int) Math.ceil((after * 100) / shelfLife);
    }
}
