package ru.job4j.total.field;

import javafx.util.Pair;
import ru.job4j.total.figures.Figure;
import ru.job4j.total.figures.FigureEmpty;
import java.util.ArrayList;
import java.util.List;

public class FieldImpl implements Field {

    private final int size;
    private final Point[][] field;

    public FieldImpl() {
        this(3);
    }

    public FieldImpl(int size) {
        this.size = size;
        this.field = new Point[size][size];
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                this.field[x][y] = new Point(x, y, new FigureEmpty());
            }
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Figure getFigure(int coor1, int coor2) {
        return this.field[coor1][coor2].getFigure();
    }

    @Override
    public boolean setFigure(int coor1, int coor2, Figure figure) {
        if (this.isBusy(coor1, coor2)) {
            return false;
        } else {
            this.field[coor1][coor2].setFigure(figure);
            return true;
        }
    }

    @Override
    public boolean isBusy(int coor1, int coor2) {
        return !(this.field[coor1][coor2].getFigure() instanceof FigureEmpty);
    }

    @Override
    public List<Pair<Integer, Integer>> getPointByFigure(Figure figure) {
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        for (Point[] points : this.field) {
            for (Point point : points) {
                if (point.getFigure().equals(figure)) {
                    result.add(new Pair<>(point.getX(), point.getY()));
                }
            }
        }
        return result;
    }

    private String insertInRow(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(str);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < this.size; y++) {
            result.append(this.insertInRow("     |"));
            for (int x = 0; x < this.size; x++) {
                result.append("  ");
                result.append(this.field[x][y].getFigure().getSign());
                result.append("  |");
            }
            result.deleteCharAt(result.length() - 1);
            result.append(System.lineSeparator());
            if (y == this.size - 1) {
                result.append(this.insertInRow("     |"));
            } else {
                result.append(this.insertInRow("_____|"));
            }
        }
        return result.toString();
    }
}
