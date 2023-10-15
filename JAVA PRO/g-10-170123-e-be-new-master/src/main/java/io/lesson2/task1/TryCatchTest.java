package io.lesson2.task1;

public class TryCatchTest {

    public static void main(String[] args) {

        System.out.println("Старт программы");
        System.out.println("Вызываем метод div");

        Integer result;

        try { // try (Объявляем входящий поток чтения из файла) - try-with-resources
            result = div(10, 0);
            // Здесь в коде открываем соединение с БД
        } catch (ArithmeticException e) {
            System.out.println("Получено сообщение об ошибке - " + e.getMessage());
            result = null;
        } finally {
            System.out.println("Отработал блок finally");
            // Закрываем соединение с БД
            // Входящий поток чтения из файла мы можем вручную не закрывать,
            // поскольку он открыт в блоке try-with-resources (он закроется автоматически)
        }

        System.out.println("Результат - " + result);
        System.out.println("Конец работы программы");
    }

    public static int div(int x, int y) {
        System.out.println("Метод div начал работу с параметрами " + x + " и " + y);
        int result;
        result = x / y;
        System.out.println("Метод div закончил работу с результатом " + result);
        return result;
    }
}