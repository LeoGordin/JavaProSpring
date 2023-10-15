package module5.lesson3_exceptions.task1;

import java.util.Scanner;

public class UserInputTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите возраст:");

//        int age = scanner.nextInt();

        int age;

        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Здесь мы можем произвести логирование
            System.out.println("Ошибка! Введено не число. Принято значение по умолчанию -1.");
            System.out.println(e.getMessage());
            e.printStackTrace();
            age = -1;
        }

        System.out.printf("Пользователь: имя - %s, возраст - %d.", name, age);
    }
}