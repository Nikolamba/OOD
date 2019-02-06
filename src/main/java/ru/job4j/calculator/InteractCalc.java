package ru.job4j.calculator;

import java.util.function.BiConsumer;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class InteractCalc {

    private final Calculator calculator;

    private double lastCalc;
    private String lastOperation;

    public InteractCalc() {
        this.calculator = new Calculator();
        this.lastOperation = null;
    }

    public double add(double first, double second) {
        return this.action(first, second, "add", calculator::add);
    }

    public double substract(double first, double second) {
        return this.action(first, second, "substract", calculator::substract);
    }

    public double multiple(double first, double second) {
        return this.action(first, second, "multiple", calculator::multiple);
    }

    public double div(double first, double second) {
        return this.action(first, second, "div", calculator::div);
    }

    private double action(double first, double second, String oper, BiConsumer<Double, Double> function) {
        function.accept(first, second);
        this.lastOperation = oper;
        this.lastCalc = this.calculator.getResult();
        return this.lastCalc;
    }

    public double useLastOperation(double first, double second) {
        if (this.lastOperation == null) {
            throw new IllegalArgumentException("Missing last calculation");
        }
        switch (this.lastOperation) {
            case "add": return this.add(first, second);
            case "substract": return this.substract(first, second);
            case "multiple": return this.multiple(first, second);
            case "div": return this.div(first, second);
            default: return 0;
        }
    }

    public double getLastCalculation() {
        return this.lastCalc;
    }

    public String getLastOperation() {
        return lastOperation;
    }
}
