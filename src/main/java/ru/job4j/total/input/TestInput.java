package ru.job4j.total.input;

import javafx.util.Pair;

import java.util.List;

public class TestInput implements Input {

    private List<Pair<Integer, Integer>> pairs;
    private int pos;

    public TestInput(List<Pair<Integer, Integer>> pairs) {
        this.pairs = pairs;
    }

    @Override
    public Pair<Integer, Integer> getPairCoor(List<Pair<Integer, Integer>> range) {
        return pairs.get(pos++);
    }
}
