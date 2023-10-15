package module6.lesson4.task2;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.printf("Поток %s начал работу.%n", getName());
            Thread.sleep(5000);
            System.out.printf("Поток %s закончил работу.%n", getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
