package module6.lesson1.task3;

public class TwoThreads extends Thread {

    @Override
    public void run() {

        for (int i = 50001; i < 100000; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                Main.count.incrementAndGet();
            }

        }

//        System.out.println("Результат при вычислении в два потока (поток 2) - " + Main.count);
    }
}