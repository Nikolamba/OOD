package ru.job4j.total;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.total.field.Field;
import ru.job4j.total.field.FieldImpl;
import ru.job4j.total.figures.FigureO;
import ru.job4j.total.figures.FigureX;
import ru.job4j.total.input.ConsoleInput;
import ru.job4j.total.input.TestInput;
import ru.job4j.total.user.CompPlayer;
import ru.job4j.total.user.User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void whenWinComp1ShoudContainWinnerMessage() {
        Field field = new FieldImpl();

        List<Pair<Integer, Integer>> user1Pairs = new ArrayList<>();
        user1Pairs.add(new Pair<>(0, 0));
        user1Pairs.add(new Pair<>(1, 1));
        user1Pairs.add(new Pair<>(2, 2));
        User user1 = new CompPlayer("comp_1", new FigureX(), new TestInput(user1Pairs));

        List<Pair<Integer, Integer>> user2Pairs = new ArrayList<>();
        user2Pairs.add(new Pair<>(0, 1));
        user2Pairs.add(new Pair<>(1, 0));
        user2Pairs.add(new Pair<>(2, 1));
        User user2 = new CompPlayer("comp_2", new FigureO(), new TestInput(user2Pairs));

        new Game(field, 3).startGame(user1, user2);

        assertTrue(new String(out.toByteArray()).contains("comp_1 is winner"));
    }

    @Test
    public void whenNoWinnerShouldContainNoWinnerMessage() {
        Field field = new FieldImpl();

        List<Pair<Integer, Integer>> user1Pairs = new ArrayList<>();
        user1Pairs.add(new Pair<>(0, 0));
        user1Pairs.add(new Pair<>(0, 1));
        user1Pairs.add(new Pair<>(1, 1));
        user1Pairs.add(new Pair<>(2, 0));
        user1Pairs.add(new Pair<>(1, 2));
        User user1 = new CompPlayer("comp_1", new FigureX(), new TestInput(user1Pairs));

        List<Pair<Integer, Integer>> user2Pairs = new ArrayList<>();
        user2Pairs.add(new Pair<>(0, 2));
        user2Pairs.add(new Pair<>(1, 0));
        user2Pairs.add(new Pair<>(2, 1));
        user2Pairs.add(new Pair<>(2, 2));
        User user2 = new CompPlayer("comp_2", new FigureO(), new TestInput(user2Pairs));

        new Game(field, 3).startGame(user1, user2);

        assertTrue(new String(out.toByteArray()).contains("No winner"));
    }

}