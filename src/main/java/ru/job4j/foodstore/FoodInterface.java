package ru.job4j.foodstore;

import java.util.Date;

public interface FoodInterface {
    String getName();
    Date getExpareDate();
    Date getCreateDate();
    double getPrice();
    int getDiscount();
}
