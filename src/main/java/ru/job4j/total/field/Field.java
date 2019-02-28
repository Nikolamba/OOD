package ru.job4j.total.field;

import javafx.util.Pair;
import ru.job4j.total.figures.Figure;

import java.util.List;

/**
 * Интерфейс, определяющий поведение поля для игры
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public interface Field {
    int getSize();
    Figure getFigure(int coor1, int coor2);
    boolean setFigure(int coor1, int coor2, Figure figure);
    boolean isBusy(int coor1, int coor2);
    List<Pair<Integer, Integer>> getPointByFigure(Figure figure);
}
