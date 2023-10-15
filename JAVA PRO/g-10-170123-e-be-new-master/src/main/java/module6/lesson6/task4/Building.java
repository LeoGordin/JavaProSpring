package module6.lesson6.task4;

import java.util.Date;

public class Building implements Runnable{

    private String city;
    private String[] stages; // Этапы строительства
    private boolean printTime; // if true -> time of construction

    public Building(String city, String[] stages, boolean printTime) {
        this.city = city;
        this.stages = stages;
        this.printTime = printTime;
    }


    @Override
    public void run() {
        for(int i = 0; i < stages.length; i++) {
            if (printTime) {
                // Berlin: Stage of construction, thread - N -> time
                System.out.printf("%s: %s, %s -> %s%n",
                        city, stages[i], Thread.currentThread().getName(), new Date());
            } else {
                System.out.printf("%s: %s, %s%n",
                        city, stages[i], Thread.currentThread().getName());
            }

            try {
                Thread.sleep((long) (Math.random() * 5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
