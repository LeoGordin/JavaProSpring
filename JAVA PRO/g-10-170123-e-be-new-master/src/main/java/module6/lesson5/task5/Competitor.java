package module6.lesson5.task5;

import java.util.concurrent.Phaser;

public class Competitor extends Thread {

    private int delayTime;
    private Phaser phaser;

    public Competitor(String name, int delayTime, Phaser phaser) {
        this.delayTime = delayTime;
        this.phaser = phaser;
        phaser.register();
        setName(name);
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delayTime);
            System.out.printf("%s приступил к соревнованию 1.%n", getName());

            Thread.sleep(delayTime);
            System.out.printf("%s закончил соревнование 1.%n", getName());

            phaser.arriveAndAwaitAdvance();

            Thread.sleep(delayTime);
            System.out.printf("%s приступил к соревнованию 2.%n", getName());

            Thread.sleep(delayTime);
            System.out.printf("%s закончил соревнование 2.%n", getName());

            phaser.arriveAndAwaitAdvance();

            Thread.sleep(delayTime);
            System.out.printf("%s приступил к соревнованию 3.%n", getName());

            Thread.sleep(delayTime);
            System.out.printf("%s закончил соревнование 3.%n", getName());
        } catch (InterruptedException e) {
            System.out.println("Ошибка!");
        }
    }
}
