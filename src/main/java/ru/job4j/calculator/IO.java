package ru.job4j.calculator;

import java.util.List;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface IO {
    List<Double> getNumbers(int number);
    void sendString(String str);
}
