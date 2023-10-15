package de.telran.g10170123ebeshop.scheduler;

import de.telran.g10170123ebeshop.domain.entity.jpa.Task;
import de.telran.g10170123ebeshop.service.jpa.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@EnableScheduling
@EnableAsync
public class ScheduleExecutor {

    private static Logger logger = LoggerFactory.getLogger(ScheduleExecutor.class);

    TaskService service = new TaskService();

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//        Task task = new Task("fixedDelayTask");
//        logger.info(task.getDescription());
//        logger.info("fixedDelayTask");
//    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//        Task task = new Task("fixedDelayTask");
//        logger.info(task.getDescription());
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//        Task task = new Task("fixedDelayTask");
//        logger.info(task.getDescription());
//
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//    @Scheduled(fixedRate = 5000)
//    public void fixedRateTask() {
//        Task task = new Task("fixedRateTask (3 seconds)");
//        logger.info(task.getDescription());
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedRate = 5000)
//    public void fixedRateTask() {
//        Task task = new Task("fixedRateTask (7 seconds)");
//        logger.info(task.getDescription());
//
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    @Async
//    @Scheduled(fixedRate = 5000)
//    public void fixedRateAsyncTask() {
//        Task task = new Task("fixed rate async task (7 seconds)");
//        logger.info(task.getDescription());
//
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//    @Scheduled(fixedDelay = 5000, initialDelay = 20000)
//    public void initialDelayTask() {
//        Task task = new Task("Initial delay task");
//        logger.info(task.getDescription());
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedDelayString = "PT03S") //Period of Time 03 seconds
//    public void initialDelayTask() {
//        Task task = new Task("Another delay format task");
//        logger.info(task.getDescription());
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedDelayString = "${interval}") //Period of Time 03 seconds
//    public void delayInPropertyTask() {
//        Task task = new Task("Delay in property task");
//        logger.info(task.getDescription());
//        service.save(task);
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    // 55 * * * * * every minute at 55 seconds
    // 0 15 9-17 * * MON-FRI // every working day from 9am to 5pm at 15 minutes
//    @Scheduled(cron = "${cron-interval}") //Period of Time 03 seconds
//    public void cronExpressionTask() {
//        Task task = new Task("Cron expression task");
//        logger.info(task.getDescription());
//        service.save(task);
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void executeTask(Task task) {
        TaskScheduler scheduler = new DefaultManagedTaskScheduler();
        //This will schedule the task every 10 seconds.
//        scheduler.schedule(() -> logger.info(task.getDescription()),
//                new CronTrigger("0,10,20,30,40,50 * * * * *"));

        // This will schedule task after any cause one time
        logger.info("Method executeTask called");
        Instant instant = Instant.now().plusSeconds(20);
        scheduler.schedule(() -> logger.info(task.getDescription()), instant);

        
    }
}
