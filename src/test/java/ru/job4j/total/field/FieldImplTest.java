package ru.job4j.total.field;

import javafx.util.Pair;
import org.junit.Test;
import ru.job4j.total.figures.FigureEmpty;
import ru.job4j.total.figures.FigureO;
import ru.job4j.total.figures.FigureX;

import java.util.List;

import static org.junit.Assert.*;

public class FieldImplTest {

    private final Field field = new FieldImpl();

    @Test
    public void whenSetFigureShouldGetSameFigure() {
        field.setFigure(1, 1, new FigureX());
        field.setFigure(0, 0, new FigureO());
        assertEquals(new FigureX(), field.getFigure(1, 1));
        assertEquals(new FigureO(), field.getFigure(0, 0));
        assertEquals(new FigureEmpty(), field.getFigure(1, 0));
    }

    @Test
    public void whenPointIsBusyShouldReturnTrue() {
        field.setFigure(1, 1, new FigureO());
        assertTrue(field.isBusy(1, 1));
        assertFalse(field.isBusy(0, 0));
    }

    @Test
    public void whenGetListPointByFigureShouldReturnCorrectList() {
        field.setFigure(0, 0, new FigureO());
        field.setFigure(0, 2, new FigureO());
        field.setFigure(1, 1, new FigureX());
        List<Pair<Integer, Integer>> list = field.getPointByFigure(new FigureO());
        assertTrue(list.contains(new Pair<>(0, 0)));
        assertTrue(list.contains(new Pair<>(0, 2)));
        assertEquals(2, list.size());
    }

}