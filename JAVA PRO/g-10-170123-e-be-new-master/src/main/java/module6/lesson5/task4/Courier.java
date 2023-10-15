package module6.lesson5.task4;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class Courier extends Thread {

    private String start;
    private String destination;
    private List<Package> packages;
    private Courier anotherCourier;
    private boolean inExchangePoint;
    private Exchanger<Package> exchanger;

    public Courier(String start, String destination, List<Package> packages, Exchanger<Package> exchanger) {
        this.exchanger = exchanger;
        this.start = start;
        this.destination = destination;
        this.packages = packages;
        start();
    }

    public void setAnotherCourier(Courier anotherCourier) {
        this.anotherCourier = anotherCourier;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int timeout = random.nextInt(9000) + 1000;

            Thread.sleep(timeout);
            System.out.printf("%s выехал из точки %s.%n", this, start);

            Thread.sleep(timeout);
            System.out.printf("%s доехал до точки обмена.%n", this);
//            inExchangePoint = true;

//            if (anotherCourier.inExchangePoint) {
//                Package packFromAnotherCourier = anotherCourier.getIrrelevantPackage();
//                packages.add(packFromAnotherCourier);
//            }

            Package pack = exchanger.exchange(getIrrelevantPackage());
            packages.add(pack);
            Thread.sleep(timeout);

//            if (anotherCourier.inExchangePoint) {
//                Package packFromAnotherCourier = anotherCourier.getIrrelevantPackage();
//                packages.add(packFromAnotherCourier);
//            }

//            inExchangePoint = false;
            System.out.printf("%s уехал из точки обмена.%n", this);

            Thread.sleep(timeout);
            System.out.printf("%s доехал до точки выгрузки.%n", this);

            Thread.sleep(timeout);
            unload();

        } catch (InterruptedException e) {
            System.out.println("Ошибка!");
        }
    }

    private void unload() {
        Iterator<Package> iterator = packages.iterator();
        while (iterator.hasNext()) {
            Package pack = iterator.next();
            if (destination.equals(pack.getTo())) {
                System.out.printf("%s успешно доставил %s.%n", this, pack);
                iterator.remove();
            }
        }

        if (packages.isEmpty()) {
            System.out.printf("%s успешно доставил все посылки.%n", this);
        } else {
            System.out.printf("%s не смог доставить все посылки.%n", this);
        }
    }

    private Package getIrrelevantPackage() {
        Iterator<Package> iterator = packages.iterator();
        while (iterator.hasNext()) {
            Package pack = iterator.next();
            if (!pack.getTo().equals(destination)) {
                iterator.remove();
                System.out.printf("%s отдал %s.%n", this, pack);
                return pack;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Курьер {%s -> %s}", start, destination);
    }
}
