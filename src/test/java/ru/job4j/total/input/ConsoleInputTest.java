package ru.job4j.total.input;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConsoleInputTest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void whenEnter2NumberShouldReturnPair() {
        System.setIn(new ByteArrayInputStream(
                ("0" + System.lineSeparator() + "0" + System.lineSeparator()).getBytes()));
        List<Pair<Integer, Integer>> range = new ArrayList<>();
        range.add(new Pair<>(0, 0));
        range.add(new Pair<>(0, 1));
        Pair<Integer, Integer> point = new ConsoleInput().getPairCoor(range);
        assertTrue(point.getKey() == 0);
        assertTrue(point.getValue() == 0);
    }

    @Test
    public void whenEnterUncorrectPairShouldContainUncorrectPair() {
        System.setIn(new ByteArrayInputStream(
                ("0" + System.lineSeparator() + "2" + System.lineSeparator()
                + "0" + System.lineSeparator() + "0" + System.lineSeparator()).getBytes()));
        List<Pair<Integer, Integer>> range = new ArrayList<>();
        range.add(new Pair<>(0, 0));
        range.add(new Pair<>(0, 1));
        new ConsoleInput().getPairCoor(range);
        assertTrue(out.toString().contains("Unavailable pair"));
    }

    @Test
    public void whenEnterUncorrectNumberShouldContainEnterCorrectNumber() {
        System.setIn(new ByteArrayInputStream(
                ("a" + System.lineSeparator() + "0" + System.lineSeparator()
                        + "0" + System.lineSeparator()).getBytes()));
        List<Pair<Integer, Integer>> range = new ArrayList<>();
        range.add(new Pair<>(0, 0));
        new ConsoleInput().getPairCoor(range);
        assertTrue(out.toString().contains("Enter correct number"));
    }
}