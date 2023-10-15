package module6.lesson2.task5;

public class Main {

    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {

        }

        thread.threadStop();
    }
}
