package ru.job4j.calculator;

import java.util.List;
import java.util.function.Function;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class EngineerCalculator extends InteractCalculator {

    public EngineerCalculator(IO io) {
        super(io);
        this.actions.add(new Sqrt(actions.size(), "Square root"));
        this.actions.add(new Sin(actions.size(), "Sinus"));
        this.actions.add(new Cos(actions.size(), "Cosinus"));
    }

    private void exec(Function<Double, Double> function) {
        io.sendString("Enter number...");
        List<Double> numbers = io.getNumbers(1);
        lastCalculation = function.apply(numbers.get(0));
        io.sendString("Result: " + Double.toString(function.apply(numbers.get(0))));
    }

    private class Sqrt implements UserAction {
        private int key;
        private String desc;

        Sqrt(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        @Override
        public int getKey() {
            return this.key;
        }

        @Override
        public void execute() {
            lastAction = this;
            exec(Math::sqrt);
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }

    private class Sin implements UserAction {
        private int key;
        private String desc;

        Sin(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        @Override
        public int getKey() {
            return this.key;
        }

        @Override
        public void execute() {
            lastAction = this;
            exec(Math::sin);
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }

    private class Cos implements UserAction {
        private int key;
        private String desc;

        Cos(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        @Override
        public int getKey() {
            return this.key;
        }

        @Override
        public void execute() {
            lastAction = this;
            exec(Math::cos);
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }
}
