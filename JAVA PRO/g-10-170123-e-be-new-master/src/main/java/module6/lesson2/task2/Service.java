package module6.lesson2.task2;

public class Service {

    public static void test(Runnable runnable) {
        runnable.run();
        new Thread(runnable).start();
    }
}