package ru.job4j.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class UserActions {

    private final List<UserAction> actions;
    private final InteractCalc calc;
    private final IO io;

    public UserActions(IO io) {
        this.calc = new InteractCalc();
        this.actions = new ArrayList<>();
        this.io = io;
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

    private void exec(BiFunction<Double, Double, Double> function) {
        io.sendString("Enter 2 numbers separated by a space");
        List<Double> numbers = io.getNumbers(2);
        io.sendString("Result: " + Double.toString(function.apply(numbers.get(0), numbers.get(1))));
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
            if (calc.getLastOperation() == null) {
                io.sendString("No last operation");
                return;
            }
            exec(calc::useLastOperation);
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
            io.sendString("Result: " + Double.toString(calc.getLastCalculation()));
        }

        @Override
        public String getDesc() {
            return this.desc;
        }
    }


}
