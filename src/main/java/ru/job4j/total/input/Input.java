package ru.job4j.total.input;

import javafx.util.Pair;

import java.util.List;

public interface Input {
    Pair<Integer, Integer> getPairCoor(List<Pair<Integer, Integer>> range);
}
