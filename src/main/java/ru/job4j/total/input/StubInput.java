package ru.job4j.total.input;

import javafx.util.Pair;

import java.util.List;
import java.util.Random;

public class StubInput implements Input {

    private Random random;

    public StubInput() {
        this.random = new Random();
    }

    @Override
    public Pair<Integer, Integer> getPairCoor(List<Pair<Integer, Integer>> range) {
        return range.get(random.nextInt(range.size()));
    }
}