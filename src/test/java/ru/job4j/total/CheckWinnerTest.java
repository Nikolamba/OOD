package ru.job4j.total;

import org.junit.Test;
import ru.job4j.total.field.Field;
import ru.job4j.total.field.FieldImpl;
import ru.job4j.total.figures.FigureX;


import static org.junit.Assert.*;

public class CheckWinnerTest {

    private CheckWinner checkWinner;
    private Field field;

    @Test
    public void whenNoWinner3x3ShouldReturnFalse() {
        field = new FieldImpl();
        field.setFigure(0, 0, new FigureX());
        field.setFigure(0, 1, new FigureX());
        field.setFigure(1, 2, new FigureX());
        field.setFigure(2, 0, new FigureX());
        field.setFigure(1, 1, new FigureX());

        checkWinner = new CheckWinner(field, 3);

        assertFalse(checkWinner.checkWin(new FigureX()));
    }

    @Test
    public void whenIsWinner3x3VerticalLineShouldReturnTrue() {
        field = new FieldImpl();
        field.setFigure(0, 1, new FigureX());
        field.setFigure(1, 1, new FigureX());
        field.setFigure(2, 1, new FigureX());

        checkWinner = new CheckWinner(field, 3);

        assertTrue(checkWinner.checkWin(new FigureX()));
    }

    @Test
    public void whenIsWinner3x3HorizontalLineShouldReturnTrue() {
        field = new FieldImpl();
        field.setFigure(2, 0, new FigureX());
        field.setFigure(2, 1, new FigureX());
        field.setFigure(2, 2, new FigureX());

        checkWinner = new CheckWinner(field, 3);

        assertTrue(checkWinner.checkWin(new FigureX()));
    }

    @Test
    public void whenIsWinner3x3RightDiagonalShouldReturnTrue() {
        field = new FieldImpl();
        field.setFigure(0, 0, new FigureX());
        field.setFigure(1, 1, new FigureX());
        field.setFigure(2, 2, new FigureX());

        checkWinner = new CheckWinner(field, 3);

        assertTrue(checkWinner.checkWin(new FigureX()));
    }

    @Test
    public void whenIsWinner3x3LeftDiagonalShouldReturnTrue() {
        field = new FieldImpl();
        field.setFigure(0, 2, new FigureX());
        field.setFigure(1, 1, new FigureX());
        field.setFigure(2, 0, new FigureX());

        checkWinner = new CheckWinner(field, 3);

        assertTrue(checkWinner.checkWin(new FigureX()));
    }

    @Test
    public void whenIsWinner5x5VerticalLineShouldReturnTrue() {
        field = new FieldImpl(5);
        field.setFigure(0, 2, new FigureX());
        field.setFigure(1, 2, new FigureX());
        field.setFigure(2, 2, new FigureX());
        field.setFigure(3, 2, new FigureX());
        field.setFigure(4, 2, new FigureX());

        checkWinner = new CheckWinner(field, 5);

        assertTrue(checkWinner.checkWin(new FigureX()));
    }

    @Test
    public void whenIsWinner5x5HorizontalLineShouldReturnTrue() {
        field = new FieldImpl(5);
        field.setFigure(0, 0, new FigureX());
        field.setFigure(0, 1, new FigureX());
        field.setFigure(0, 2, new FigureX());
        field.setFigure(0, 3, new FigureX());
        field.setFigure(0, 4, new FigureX());

        checkWinner = new CheckWinner(field, 5);

        assertTrue(checkWinner.checkWin(new FigureX()));
    }

    @Test
    public void whenIsWinner5x5RightDiagonalShouldReturnTrue() {
        field = new FieldImpl(5);
        field.setFigure(0, 0, new FigureX());
        field.setFigure(1, 1, new FigureX());
        field.setFigure(2, 2, new FigureX());
        field.setFigure(3, 3, new FigureX());
        field.setFigure(4, 4, new FigureX());

        checkWinner = new CheckWinner(field, 5);

        assertTrue(checkWinner.checkWin(new FigureX()));
    }

    @Test
    public void whenIsWinner5x5LeftDiagonalShouldReturnTrue() {
        field = new FieldImpl(5);
        field.setFigure(4, 0, new FigureX());
        field.setFigure(3, 1, new FigureX());
        field.setFigure(2, 2, new FigureX());
        field.setFigure(1, 3, new FigureX());
        field.setFigure(0, 4, new FigureX());

        checkWinner = new CheckWinner(field, 5);

        assertTrue(checkWinner.checkWin(new FigureX()));
    }

}