package module6.lesson3.task5;

public class Main {

    private static int counter = 0;

    public static void increment() {
        counter++;
    }

    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ignored) {

        }

        System.out.println("Значение счётчика - " + counter);
    }
}
