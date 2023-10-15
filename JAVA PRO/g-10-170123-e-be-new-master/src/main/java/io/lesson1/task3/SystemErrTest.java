package io.lesson1.task3;

public class SystemErrTest {

    public static void main(String[] args) {

        System.out.println(div(10, 0));
    }

    public static int div(int x, int y) {
        if (y == 0) {
            System.err.println("Ошибка! Делитель не может быть равен нулю.");
            return -1;
        }
        return x / y;
    }
}