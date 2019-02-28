package ru.job4j.total.user;

import javafx.util.Pair;
import ru.job4j.total.input.Input;
import ru.job4j.total.figures.Figure;

import java.util.List;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class CompPlayer extends AbstractUser {

    public CompPlayer(String name, Figure figure, Input input) {
        super(name, figure, input);
    }

    @Override
    public Pair<Integer, Integer> getPair(List<Pair<Integer, Integer>> range) {
        return input.getPairCoor(range);
    }
}
