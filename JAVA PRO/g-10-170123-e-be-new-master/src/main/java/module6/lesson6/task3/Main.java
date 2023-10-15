package module6.lesson6.task3;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private static int currentId = 0;

    private static int getId() {
        return ++currentId;
    }

    public static void main(String[] args) {

        Callable<Integer> task = () -> {

            int id = getId();
            int result = 0;

            Random random = new Random();
            int timeout = random.nextInt(4000) + 1000;

            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(timeout);
                    result += id;
                    System.out.printf("Thread %s increased value by %d. %n",
                            Thread.currentThread().getName(), id);
                } catch (Exception e) {
                    System.err.println("ERROR!");
                }
            }

            return result;
        };

        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<Integer>[] resultBoxes = new Future[5];

        for (int i = 0; i < resultBoxes.length; i++) {
            resultBoxes[i] = service.submit(task);
        }

        int result = 0;

        for (Future<Integer> resultBox : resultBoxes) {
            try {
                result += resultBox.get();
            } catch (Exception e) {
                System.err.println("ERROR!");
            }
        }

        System.out.println("Result is: " + result);

        service.shutdown();
    }
}
