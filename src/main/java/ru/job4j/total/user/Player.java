package ru.job4j.total.user;

import javafx.util.Pair;
import ru.job4j.total.input.Input;
import ru.job4j.total.figures.Figure;

import java.util.List;

public class Player extends AbstractUser {

    public Player(String name, Figure figure, Input input) {
        super(name, figure, input);
    }

    @Override
    public Pair<Integer, Integer> getPair(List<Pair<Integer, Integer>> range) {
        return input.getPairCoor(range);
    }
}
