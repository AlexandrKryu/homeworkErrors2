package org.example;

import java.util.Scanner;

public class Task1 {

    final static Scanner CONSOLE = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nЗадача 1. Метод ввода вещественного числа.");

        do {

            float value = askFloat("\nВведите вещественное число: ",
                    "Некорректный ввод: Требуется вещественное число. Пожалуйста попробуйте снова.");

            System.out.printf("Введено число %f\n", value);

        } while (askYesNo(CONSOLE, "\nЖелаете повторить (Д/н)? ", true));
    }

    public static float askFloat(String prompt, String wrongWarning) {
        boolean wrongType = false;
        while (true) {
            if (wrongType) {
                if (wrongWarning != null) {
                    System.out.println(wrongWarning);
                }
            }

            System.out.print(prompt);
            String rawInp = CONSOLE.nextLine();
            Float value = tryParseFloat(rawInp);
            if (!(wrongType = (value == null))) {
                return value;
            }
        }
    }

    private static Float tryParseFloat(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        try {
            return Float.parseFloat(str.replace(",", ".")); // Float.parseFloat isn't internationalized, uses dot
        } catch (NumberFormatException e) {
            return null;
        }
    }
    public static boolean askYesNo(Scanner console, String prompt, boolean isYesDefault) {
        System.out.print(prompt);
        var answer = console.nextLine();

        if (answer.isBlank()) {
            return isYesDefault;
        }

        if (answer.startsWith("y") || answer.startsWith("д") || answer.startsWith("l")) {
            return true;
        } else if (answer.startsWith("n") || answer.startsWith("н") || answer.startsWith("т")) {
            return false;
        } else {
            return isYesDefault;
        }
    }
}