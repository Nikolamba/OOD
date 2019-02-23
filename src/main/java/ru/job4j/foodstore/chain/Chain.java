package ru.job4j.foodstore.chain;

import ru.job4j.foodstore.Food;

import java.util.Calendar;

public interface Chain {
    void setNextChain(Chain nextChain);
    Chain getNextChain();
    void process(Food food);
    void setCalendar(Calendar calendar);

    default int shelfLife(Food food, Calendar calendar) {
        long shelfLife = food.getExpareDate().getTime() - food.getCreateDate().getTime();
        long after = calendar.getTime().getTime() - food.getCreateDate().getTime();
        return (int) ((after * 100) / shelfLife);
    }
}
