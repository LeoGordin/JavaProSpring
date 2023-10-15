package module6.lesson6.task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {

    public static void main(String[] args) {

        // Company has equipment only for one construction at one time
        // Construction will happen sequentially

        String stages [] = {
                "1. Project",
                "2. Start building",
                "3. Finish building",
                "4. Finishing works",
                "5. Yaaaay!"
        };

    //    new Thread(new Building("Berlin", stages, false)).start();

        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute(new Building("Berlin", stages, false));
        service.execute(new Building("Dusseldorf", stages, false));
        service.execute(new Building("Essen", stages, false));
        service.execute(new Building("Dortmund", stages, false));

        service.shutdown();
    }
}
