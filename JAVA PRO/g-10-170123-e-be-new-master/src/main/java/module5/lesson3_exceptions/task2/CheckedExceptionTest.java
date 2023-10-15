package module5.lesson3_exceptions.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CheckedExceptionTest {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader("test.txt");
             BufferedReader br = new BufferedReader(reader)) {
            System.out.println(br.readLine());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите первое число:");
            int x = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите второе число:");
            int y = Integer.parseInt(scanner.nextLine());

            System.out.println("Результат деления чисел: " + (x / y));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя.");
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число.");
        }

        System.out.println("Программа завершена успешно.");
    }
}
