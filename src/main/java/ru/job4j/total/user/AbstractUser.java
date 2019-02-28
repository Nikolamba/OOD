package ru.job4j.total.user;

import ru.job4j.total.input.Input;
import ru.job4j.total.figures.Figure;

/**
 * Абстрактный класс, реализующий общее поведение пользователя
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public abstract class AbstractUser implements User {
    protected final Input input;
    protected final Figure figure;
    protected String name;

    public AbstractUser(String name, Figure figure, Input input) {
        this.name = name;
        this.figure = figure;
        this.input = input;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Figure getFigure() {
        return this.figure;
    }
}
