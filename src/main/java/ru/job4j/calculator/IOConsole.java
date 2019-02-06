package ru.job4j.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class IOConsole implements IO {

    @Override
    public List<Double> getNumbers(int number) {
        List<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < number; i++) {
            if (scanner.hasNextDouble()) {
                numbers.add(scanner.nextDouble());
            } else {
                throw new IllegalArgumentException("No number entered");
            }
        }
        return numbers;
    }

    @Override
    public void sendString(String str) {
        System.out.println(str);
    }
}
