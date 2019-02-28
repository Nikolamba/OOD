package ru.job4j.total.user;

import javafx.util.Pair;
import ru.job4j.total.figures.Figure;

import java.util.List;

/**
 * Класс, определяющий поведение пользователя
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface User {
    Pair<Integer, Integer> getPair(List<Pair<Integer, Integer>> range);
    String getName();
    Figure getFigure();
}
