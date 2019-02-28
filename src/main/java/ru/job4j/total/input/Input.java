package ru.job4j.total.input;

import javafx.util.Pair;

import java.util.List;

/**
 * Интерфейс для ввода данных
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface Input {
    Pair<Integer, Integer> getPairCoor(List<Pair<Integer, Integer>> range);
}
