package module6.lesson6.task1;

import java.util.Random;

public class MyThread extends Thread {

    private int id;

    public MyThread(int id) {
        this.id = id;
        start();
    }

    @Override
    public void run() {

        Random random = new Random();
        int timeout = random.nextInt(4000) + 1000;

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(timeout);
                Main.addToCounter(id);
                System.out.printf("Thread %s increased value of variable by %d .%n", getName(), id);
            } catch (InterruptedException e) {
                System.err.println("ERROR!");
            }
        }
    }
}
