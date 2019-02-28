package ru.job4j.total.field;

import ru.job4j.total.figures.Figure;
import ru.job4j.total.figures.FigureEmpty;

/**
 * Класс для определения точки на поле
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class Point {
    private final int x;
    private final int y;
    private Figure figure;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.figure = new FigureEmpty();
    }

    public Point(int x, int y, Figure figure) {
        this.x = x;
        this.y = y;
        this.figure = figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Figure getFigure() {
        return figure;
    }
}
