package module6.lesson1.task1;

public class Main {

    public static void main(String[] args) {

        // Два способа создания потоков:
        // 1. Наследование от класса Thread
        //    При этом запуск отдельного потока осуществляется при
        //    помощи вызова метода start() объекта нашего класса.
        // 2. Реализация интерфейса Runnable
        //    При этом запуск отдельного потока осуществляется путём
        //    передачи объекта нашего класса в конструктор объекта
        //    класса Thread и вызова метода start() у этого объекта.

        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Главный поток: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Главный поток прерван");
            }
        }
    }
}