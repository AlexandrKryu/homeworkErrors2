package org.example;

import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {

        Integer[] intArray = IntStream.range(0, 5).boxed().toArray(Integer[]::new);
        int d = 0;

        try {
            // приводим знаменатель к double, поскольку тип назначения (результата)
            // явно намекает, что требуется нецелочисленное деление
            double catchedRes1 = intArray[8] / (double) d;
            System.out.println("catchedRes1 = " + catchedRes1);



            // } catch (IndexOutOfBoundsException | NullPointerException e) {

        } catch (RuntimeException e) {
            // Поскольку все потенциально рассматриваемые исключения
            // являются подтипами RuntimeException, а какой-то специфической
            // обработки исключений в исходном задании явно не требуется,
            // с целью упрощения чтения/разработки выбрано отлавливание любых
            // RuntimeException!

            System.err.println("Catching exception: " + e);

        }
    }
}