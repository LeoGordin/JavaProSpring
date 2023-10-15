package module6.lesson5.task1;

import java.util.concurrent.Semaphore;

public class Car extends Thread {

    private Semaphore semaphore;

    public Car(String name, Semaphore semaphore) {
        this.semaphore = semaphore;
        setName(name);
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);

            System.out.printf("Автомобиль %s на старте.%n", getName());
            Thread.sleep(3000);

            long start = System.currentTimeMillis();
            System.out.printf("Автомобиль %s начал движение.%n", getName());
            Thread.sleep(3000);

            System.out.printf("Автомобиль %s подъехал к тоннелю.%n", getName());
            Thread.sleep(3000);

            semaphore.acquire();
            System.out.printf("Автомобиль %s въехал в тоннель.%n", getName());
            Thread.sleep(3000);

            System.out.printf("Автомобиль %s выехал их тоннеля.%n", getName());
            semaphore.release();
            Thread.sleep(3000);

            System.out.printf("Автомобиль %s финишировал за %d секунд.%n",
                    getName(), (System.currentTimeMillis() - start) / 1000);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Ошибка!");
        }
    }
}