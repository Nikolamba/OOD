package ru.job4j.total.input;

import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

/**
 * Класс, реализующий ввод пользователя с консоли
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class ConsoleInput implements Input, UserInput {

    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Pair<Integer, Integer> getPairCoor(List<Pair<Integer, Integer>> range) {
        int c1 = -1, c2 = -1;
        while (!range.contains(new Pair<>(c1, c2))) {
            System.out.println("Enter first coordinate");
            while (!scanner.hasNextInt()) {
                System.out.println("Enter correct number");
                scanner.next();
            }
            c1 = scanner.nextInt();
            System.out.println("Enter second coordinate");
            while (!scanner.hasNextInt()) {
                System.out.println("Enter correct number");
                scanner.next();
            }
            c2 = scanner.nextInt();
            if (!range.contains(new Pair<>(c1, c2))) {
                System.out.println("Unavailable pair. Try again");
            }
        }
        return new Pair<>(c1, c2);
    }

    @Override
    public int getInt(int min, int max) {
        boolean interupt = true;
        int result = 0;
        while (interupt) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if (result >= min && result <= max) {
                    interupt = false;
                } else {
                    System.out.println("Enter a number between " + min + " and " + max);
                }
            } else {
                System.out.println("No number entered. Try again");
            }
        }
        return result;
    }
}
