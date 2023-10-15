package module6.lesson1.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

//    private static int count;
//    public static int count2;
    public static AtomicInteger count3 = new AtomicInteger(0);
    public static int number = 5;

//    public static synchronized void increment() {
//        count++;
//    }

    public static void main(String[] args) {

        TwoThreads threads = new TwoThreads();
        threads.start();

        for (int i = Integer.MIN_VALUE; i < 0; i++) {
            if (i % number == 0) {
                count3.incrementAndGet();
            }
        }

        try {
            threads.join();
        } catch (InterruptedException e) {
            System.out.println("Ошибка!");
        }


        System.out.println("Результат при вычислении в два потока - " + count3);
    }
}
