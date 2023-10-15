package module6.lesson6.task2;

import java.util.concurrent.*;

public class CallableFutureTest {

    public static void main(String[] args) {

//        Runnable runnable = () -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw  new RuntimeException();
//            }
//            System.out.println("Runnable finished");
//        };
//
//        new Thread(runnable).start();
//
//        System.out.println("Main Thread finished");

        Callable<Integer> callable = () -> {

            int x = 2;
            int y = 3;
            int result = x + y;
            Thread.sleep(5000);

            return result;
        };

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(callable);

        int result;
        try {
            result = future.get();
//            result = future.get(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.err.println("Result is unavailable");
            result = 0;
        }

        System.out.println("Result is: " + result);
    }
}
