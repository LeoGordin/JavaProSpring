package module6.lesson1.task3;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        TwoThreads threads = new TwoThreads();
        threads.start();

        for (int i = 2; i < 50000; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count.incrementAndGet();
            }
        }

        try {
            threads.join();
        } catch (InterruptedException e) {
            System.out.println("Ошибка!");
        }

        System.out.println("Результат при вычислении в два потока - " + count);
    }
}