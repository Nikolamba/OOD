package ru.job4j.foodstore;

import java.util.Date;

/**
 * Интерфейс, определяющий поведение модели "еда"
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface FoodInterface {
    String getName();
    Date getExpareDate();
    Date getCreateDate();
    double getPrice();
    int getDiscount();
    void setDiscount(int discount);
    boolean canReproduct();
    boolean isVegetable();
}
