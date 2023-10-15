package module5.lesson3_exceptions.task4;

import java.util.Scanner;

public class UserRegistration {

    public static void main(String[] args) {

        // Регистрация пользователя.
        // При регистрации пользователь должен указать свой возраст.
        // Запрещено регистрироваться пользователям младше 12 лет.
        // Запрещено регистрироваться пользователям старше 120 лет.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите возраст:");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Введённый возраст - " + age);

        try {
            registration(age);
        } catch (TooBigAgeException | TooSmallAgeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Программа завершила работу успешно.");
    }

    public static void registration(int age) throws TooBigAgeException {
        if (age < 12) {
            throw new TooSmallAgeException("Возраст слишком мал");
        } else if (age > 120) {
            throw new TooBigAgeException("Возраст слишком велик.");
        } else {
            System.out.println("Регистрация прошла успешно.");
        }
    }
}
