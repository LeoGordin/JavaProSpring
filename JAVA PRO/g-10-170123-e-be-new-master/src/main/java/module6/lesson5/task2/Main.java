package module6.lesson5.task2;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(5);

        new Passenger("Иван", latch);
        new Passenger("Пётр", latch);
        new Passenger("Сидор", latch);
        new Passenger("Поликарп", latch);
        new Passenger("Ефистафий", latch);
    }
}