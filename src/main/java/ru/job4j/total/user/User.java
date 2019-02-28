package ru.job4j.total.user;

import javafx.util.Pair;
import ru.job4j.total.figures.Figure;

import java.util.List;

public interface User {
    Pair<Integer, Integer> getPair(List<Pair<Integer, Integer>> range);
    String getName();
    Figure getFigure();
}
