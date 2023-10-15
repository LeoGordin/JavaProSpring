package module6.lesson2.task5;

public class MyThread extends Thread {

    private boolean isStopped;

    public void threadStop() {
        isStopped = true;
    }

    @Override
    public void run() {

        int seconds = 0;

        while (!isStopped) {
            System.out.println("Прошло секунд - " + seconds++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {

            }
        }
    }
}
