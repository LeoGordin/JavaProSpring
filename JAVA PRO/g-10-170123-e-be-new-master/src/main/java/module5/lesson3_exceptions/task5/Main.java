package module5.lesson3_exceptions.task5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Запросить значение n у пользователя.
        // Перенести код в метод, который принимает n как аргумент.
        // Посмотреть, какие ошибки возможны в данном коде и для каждой
        // ошибки создать пользовательское исключение.
        // Выбросить эти исключения в нужное время и обработать их в main.

        int n;
        System.out.println("Please enter a whole number:");
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        try {
            testingExceptions(n);
        } catch (DivideByZeroException e) {
            System.out.println("Not allowed to divide by zero");
        } catch (NegativeIndexException e) {
            System.out.println("Not allowed to use negative value for the size");
        } catch (IndexForArrayIsIncorrectException e) {
            System.out.println("Incorrect index.");
            e.printStackTrace();
        }
    }

    public static void testingExceptions(int n) throws DivideByZeroException, NegativeIndexException, IndexForArrayIsIncorrectException {
        if (n == 0) {
            throw new DivideByZeroException();
        }
        int x = 10 / n;
        System.out.println(x);
        if (n < 0) {
            throw new NegativeIndexException();
        }
        int[] array = new int[n];
        System.out.println(array.length);
        try {
            System.out.println(array[n]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IndexForArrayIsIncorrectException("Неверный индекс.", e);
        }
    }
}