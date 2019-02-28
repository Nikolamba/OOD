package ru.job4j.total.input;

import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

/**
 * Класс, реализующий ввод пользователя с консоли
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class ConsoleInput implements Input {

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
            }
            c1 = scanner.nextInt();
            System.out.println("Enter second coordinate");
            while (!scanner.hasNextInt()) {
                System.out.println("Enter correct number");
            }
            c2 = scanner.nextInt();
            if (!range.contains(new Pair<>(c1, c2))) {
                System.out.println("Unavailable pair. Try again");
            }
        }
        return new Pair<>(c1, c2);
    }
}
