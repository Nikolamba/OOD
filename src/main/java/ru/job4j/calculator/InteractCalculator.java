package ru.job4j.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class InteractCalculator {

    protected final List<UserAction> actions;
    protected final Calculator calc;
    protected final IO io;
    protected UserAction lastAction;
    protected double lastCalculation;

    public InteractCalculator(IO io) {
        this.io = io;
        this.calc = new Calculator();
        this.actions = new ArrayList<>();
        this.lastAction = null;
        this.actions.add(new Add(0, "Add of 2 numbers"));
        this.actions.add(new Substract(1, "Substraction of 2 numbers"));
        this.actions.add(new Multiple(2, "Multiplication of 2 numbers"));
        this.actions.add(new Div(3, "Division of 2 numbers"));
        this.actions.add(new LastOperation(4, "Use last operation"));
        this.actions.add(new LastCalculation(5, "Show last calculation"));

    }

    public void executeAction(int num) {
        this.actions.get(num).execute();
    }

    public int getMenuSize() {
        return this.actions.size();
    }

    public void showMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("---------------------");
        menu.append(System.lineSeparator());
        for (UserAction action : actions) {
            menu.append(action.getKey());
            menu.append(". ");
            menu.append(action.getDesc());
            menu.append(System.lineSeparator());
        }
        menu.append("'exit' to exit");
        menu.append(System.lineSeparator());
        menu.append("---------------------");
        io.sendString(menu.toString());
    }

    private void exec(BiConsumer<Double, Double> function) {
        io.sendString("Enter 2 numbers separated by a space");
        List<Double> numbers = io.getNumbers(2);
        function.accept(numbers.get(0), numbers.get(1));
        this.lastCalculation = calc.getResult();
        io.sendString("Result: " + Double.toString(calc.getResult()));
    }

    private class Add implements UserAction {

        private int key;
        private String desc;

        Add(int key, String desc) {
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
            exec(calc::add);
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }

    private class Substract implements UserAction {

        private int key;
        private String desc;

        Substract(int key, String desc) {
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
            exec(calc::substract);
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }

    private class Multiple implements UserAction {

        private int key;
        private String desc;

        Multiple(int key, String desc) {
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
            exec(calc::multiple);
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }

    private class Div implements UserAction {

        private int key;
        private String desc;

        Div(int key, String desc) {
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
            exec(calc::div);
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }

    private class LastOperation implements UserAction {

        private int key;
        private String desc;

        LastOperation(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        @Override
        public int getKey() {
            return this.key;
        }

        @Override
        public void execute() {
            if (lastAction == null) {
                io.sendString("No last operation");
                return;
            }
            executeAction(lastAction.getKey());
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }

    private class LastCalculation implements UserAction {

        private int key;
        private String desc;

        LastCalculation(int key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        @Override
        public int getKey() {
            return this.key;
        }

        @Override
        public void execute() {
            io.sendString("Result: " + Double.toString(lastCalculation));
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }


}
