package module6.lesson5.task3;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(2, new Ferryboat());

        new Truck("Man", barrier);
        new Truck("Mercedes", barrier);
        new Truck("Volvo", barrier);
        new Truck("Scania", barrier);
        new Truck("Iveco", barrier);
        new Truck("Mack", barrier);
        new Truck("Peterbilt", barrier);
        new Truck("Kenworth", barrier);
    }
}
