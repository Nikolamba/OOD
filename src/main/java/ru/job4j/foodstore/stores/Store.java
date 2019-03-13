package ru.job4j.foodstore.stores;

import ru.job4j.foodstore.Food;

import java.util.Calendar;
import java.util.List;

public interface Store {
    List<Food> getHeap();
    boolean process(Food food);
    void setCalendar(Calendar calendar);

    default int shelfLife(Food food, Calendar calendar) {
        long shelfLife = food.getExpareDate().getTime() - food.getCreateDate().getTime();
        long after = calendar.getTime().getTime() - food.getCreateDate().getTime();
        System.out.println((int)Math.ceil((after * 100) / shelfLife));
        return (int)Math.ceil((after * 100) / shelfLife);
    }
}
