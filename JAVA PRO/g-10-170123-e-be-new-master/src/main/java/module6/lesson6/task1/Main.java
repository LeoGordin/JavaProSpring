package module6.lesson6.task1;

public class Main {

    private static int counter = 0;

    public static synchronized void addToCounter(int value) {
        counter += value;
    }

    public static void main(String[] args) {

        // Пять потоков. Каждый поток должен увеличить значение
        // общей переменной пять раз, при этом увеличение переменной
        // должно происходить на значение идентификатора данного потока.
        // Потоки имеют идентификаторы от 1 до 5.

        MyThread[] threads = new MyThread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(i+1);
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("final value of variable is: " + counter);

    }
}
