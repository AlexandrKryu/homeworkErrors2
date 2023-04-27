package org.example;
import java.util.Scanner;

public class Task4 {

    final static Scanner CONSOLE = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nЗадача 4. Обработка исключения при вводе строки.");

        String myInput = null;
        do {

            try {
                myInput = askString("\nВведите непустую строку: ");
            } catch (Task4.EmptyLineException e) {
                myInput = null;
                System.out.println("Некорректный ввод: Требуется непустая строка! Пожалуйста попробуйте снова.");
            }

        } while (myInput == null);

        System.out.println("\nВведена строка: " + myInput);
    }

    public static String askString(String prompt) throws Task4.EmptyLineException {

        System.out.print(prompt);
        String input = CONSOLE.nextLine();
        if (input == null || input.isBlank()) {
            throw new EmptyLineException();
        }
        return input;
    }

    public static class EmptyLineException extends Exception {
    }
}