package io.lesson1.task2;

import java.util.Date;

public class PrintFTest {

    public static void main(String[] args) {

        System.out.printf("One%nTwo%nThree%n");
        System.out.println("One\nTwo\nThree\n");

        String name = "Иванов Иван";
        int course = 3;
        double avgRate = 4.88;

        System.out.printf("Студент: имя - %s, курс - %d, средний балл - %f%n", name, course, avgRate);
        System.out.println("Студент: имя - " + name + ", курс - " + course + ", средний балл - " + avgRate);

        System.out.println();

        boolean b = true;
        boolean b1 = false;
        boolean result = b && b1;

        System.out.printf("Значение переменной b - %b, значение b1 - %b, значение b && b1 - %B%n", b, b1, result);

        Cat cat = new Cat();

        System.out.printf("Существует ли кот? - %b%n", cat);

        cat = null;

        System.out.printf("Существует ли кот? - %b%n", cat);

        String hello = "Hello World!";

        System.out.printf("Строка - %.6s%n", hello);

        char ch = 'a';

        System.out.printf("Символ - %c.%n", ch);
        System.out.printf("Символ в верхнем регистре - %C.%n", ch);

        double pi = Math.PI;
        System.out.println(pi);

        System.out.printf("Округлённое число ПИ - %.3f.%n", pi);

        double d = 123.456789;
        System.out.printf("%50.6f%n", d);
        System.out.printf("%50.3f%n", d);

        Date date = new Date();
        System.out.println(date);

        System.out.printf("%tT%n", date);

        System.out.printf("Часы - %tH, минуты - %tM, секунды - %tS.%n", date, date, date);
        System.out.printf("%1$tA, %1$td %1$tB %1$tY года.%n", date);
    }
}
