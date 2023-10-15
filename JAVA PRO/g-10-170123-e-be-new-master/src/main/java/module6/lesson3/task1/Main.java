package module6.lesson3.task1;

public class Main {

    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.setName("Alpha");
        thread2.setName("Beta");

        thread1.start();
        thread2.start();
    }
}
