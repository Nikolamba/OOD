package ru.job4j.calculator;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface UserAction {
    int getKey();
    void execute();
    String getDesc();
}
