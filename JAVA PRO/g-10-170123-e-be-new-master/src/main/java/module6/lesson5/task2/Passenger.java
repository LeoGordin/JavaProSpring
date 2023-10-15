package module6.lesson5.task2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Passenger extends Thread {

    private CountDownLatch latch;

    public Passenger(String name, CountDownLatch latch) {
        this.latch = latch;
        setName(name);
        start();
    }

    @Override
    public void run() {
        try {
            long start = System.currentTimeMillis();
            Random random = new Random();
            int timeout = random.nextInt(9000) + 1000;
            Thread.sleep(timeout);

            System.out.printf("%s вошёл в аэропорт.%n", getName());
            Thread.sleep(timeout);

            System.out.printf("%s сдал багаж и зарегистрировался.%n", getName());
            Thread.sleep(timeout);

            System.out.printf("%s прошёл паспортный контроль.%n", getName());
            Thread.sleep(timeout);

            System.out.printf("%s совершает посадку в самолёт.%n", getName());
            Thread.sleep(timeout);

            latch.countDown();
            latch.await();

            System.out.printf("%s вылетел, время вылета - %d.%n",
                    getName(), (System.currentTimeMillis() - start) / 1000);
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println("Ошибка!");
        }
    }
}
