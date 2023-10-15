package module6.lesson4.task1;

public class Crossbow {

    private int arrows = 10;

    public synchronized void fire() {
        try {
            while (arrows > 0) {
                Thread.sleep(1000);
                System.out.println("Произведён выстрел по цели. Осталось стрел - " + --arrows);
            }

            System.out.println("Стрелы закончились!");
            wait();
            System.out.println("Стрелы в колчан добавлены.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void reload() {
        try {
            System.out.println("Началось наполнение колчана.");
            arrows += 10;
            System.out.println("Стрелы добавлены. Количество стрел - " + arrows);
            notify();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
