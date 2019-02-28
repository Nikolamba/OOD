package ru.job4j.total;

import ru.job4j.total.field.Field;
import ru.job4j.total.figures.Figure;
import ru.job4j.total.user.User;

/**
 * A class that check if there is a win.
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class CheckWinner {

    private final Field field;
    private final int vicCondition;

    public CheckWinner(Field field, int vicCondition) {
        this.field = field;
        this.vicCondition = vicCondition;
    }

    public boolean checkWin(User user) {
        int count = this.field.getSize() - vicCondition + 1;
        for (int y = 0; y < count; y++) {
            for (int x = 0; x < count; x++) {
                if (checkRightDiagonal(user.getFigure(), x, y)
                        || checkLeftDiagonal(user.getFigure(), x, y)
                        || checkLines(user.getFigure(), x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRightDiagonal(Figure figure, int x, int y) {
        boolean toright = true;
        for (int i = x, k = y; i < vicCondition + x; i++, k++) {
            toright &= (this.field.getFigure(i, k).equals(figure));
        }
        return toright;
    }

    private boolean checkLeftDiagonal(Figure figure, int x, int y) {
        boolean toleft = true;
        for (int i = this.vicCondition - 1 + x, k = y; i >= x; i--, k++) {
            toleft &= (this.field.getFigure(i, k).equals(figure));
        }
        return toleft;
    }

    private boolean checkLines(Figure figure, int x, int y) {
        boolean cols, rows;
        for (int col = x; col < vicCondition + x; col++) {
            cols = true; rows = true;
            for (int row = y; row < vicCondition + y; row++) {
                cols &= (this.field.getFigure(col, row).equals(figure));
                rows &= (this.field.getFigure(row, col).equals(figure));
            }
            if (cols || rows) {
                return true;
            }
        }
        return false;
    }
}
