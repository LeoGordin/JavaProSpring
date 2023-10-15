package module6.lesson1.task2;

public class TwoThreads extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (i % Main.number == 0) {
                Main.count3.incrementAndGet();
            }
        }

//        System.out.println("Результат при вычислении в два потока (поток 2) - " + Main.count);
    }
}