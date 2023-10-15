package module6.lesson2.task3;

public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("Затраченное время - " + duration);
    }
}
