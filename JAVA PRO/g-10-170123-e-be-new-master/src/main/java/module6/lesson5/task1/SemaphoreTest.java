package module6.lesson5.task1;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);

        new Car("Хонда", semaphore);
        new Car("Ауди", semaphore);
        new Car("Тойота", semaphore);
        new Car("БМВ", semaphore);
    }
}