package ru.job4j.total.figures;

import java.util.Objects;

public abstract class AbstractFigure implements Figure {

    protected final char sign;

    public AbstractFigure(char sign) {
        this.sign = sign;
    }

    @Override
    public char getSign() {
        return this.sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractFigure that = (AbstractFigure) o;
        return sign == that.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign);
    }
}
