package module6.lesson6.task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example2 {

    public static void main(String[] args) {


        // Company has equipment for 2 constructions at one time

        String stages[] = {
                "1. Project",
                "2. Start building",
                "3. Finish building",
                "4. Finishing works",
                "5. Yaaaay!"
        };

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(new Building("Berlin", stages, false));
        service.execute(new Building("Dusseldorf", stages, false));
        service.execute(new Building("Essen", stages, false));
        service.execute(new Building("Dortmund", stages, false));

        service.shutdown();

    }
}
