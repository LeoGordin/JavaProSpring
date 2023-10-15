package module6.lesson5.task3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Truck extends Thread {

    private CyclicBarrier barrier;

    public Truck(String name, CyclicBarrier barrier) {
        this.barrier = barrier;
        setName(name);
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                Random random = new Random();
                int timeout = random.nextInt(9000) + 1000;
                Thread.sleep(timeout);

                System.out.printf("%s подъехал к переправе.%n", getName());

                barrier.await();

                System.out.printf("%s достиг другого берега.%n", getName());
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Ошибка!");
        }
    }
}