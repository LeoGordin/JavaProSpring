package module6.lesson6.task4;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example4 {

    public static void main(String[] args) {

        // Company has equipment for all constructions at one time,
        // but construction should start at defined time

        String stages [] = {
                "1. Project",
                "2. Start building",
                "3. Finish building",
                "4. Finishing works",
                "5. Yaaaay!"
        };

        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

//        service.execute(new Building("Berlin", stages, false));
//        service.execute(new Building("Dusseldorf", stages, false));
//        service.execute(new Building("Essen", stages, false));
//        service.execute(new Building("Dortmund", stages, false));

        System.out.println("Time before construction: " + new Date());

        service.schedule(new Building("Berlin", stages, true), 3, TimeUnit.SECONDS);
        service.schedule(new Building("Dusseldorf", stages, true), 4, TimeUnit.SECONDS);
        service.schedule(new Building("Essen", stages, true), 5, TimeUnit.SECONDS);
        service.schedule(new Building("Dortmund", stages, true), 8, TimeUnit.SECONDS);

        service.shutdown();

    }
}
