package module6.lesson3.task5;

import static module6.lesson3.task5.Monitors.*;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            // Здесь какой-то несинхронизированный код
            synchronized (MONITOR) {
                Main.increment();
            }
            // Здесь какой-то несинхронизированный код
        }
    }
}
