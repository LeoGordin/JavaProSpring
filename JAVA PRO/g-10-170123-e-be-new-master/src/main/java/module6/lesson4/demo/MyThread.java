package module6.lesson4.demo;

public class MyThread extends Thread {

    @Override
    public synchronized void run() {
        try {
            Thread.sleep(3000);
            System.out.println("Поток входит в режим ожидания");
            wait(3000);
            System.out.println("Поток вышел из режима ожидания");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
