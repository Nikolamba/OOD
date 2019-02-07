package ru.job4j.calculator;

import java.util.Scanner;

/**
 * @author Nikolay Meleshkin (sol.of.f@mail.ru)
 * @version 0.1
 */
public class StartCalc {
    private final InteractCalculator calculator;

    public StartCalc(IO ioSerivce) {
        this.calculator = new InteractCalculator(ioSerivce);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        while (!line.equalsIgnoreCase("exit")) {
            this.calculator.showMenu();
            if (scanner.hasNextInt()) {
                int sign = scanner.nextInt();
                if (0 <= sign && sign <= this.calculator.getMenuSize()) {
                    this.calculator.executeAction(sign);
                } else {
                    System.out.println("Enter available menu item");
                }
            } else {
                line = scanner.nextLine();
                if (!line.equalsIgnoreCase("exit")) {
                    System.out.println("this is not a menu item");
                }
            }
        }
    }

    public static void main(String[] args) {
        new StartCalc(new IOConsole()).start();
    }
}
