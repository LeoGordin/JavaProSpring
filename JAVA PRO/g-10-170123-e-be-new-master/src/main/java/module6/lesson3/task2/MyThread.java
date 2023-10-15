package module6.lesson3.task2;

public class MyThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            FileService.writeToFile(String.format("%s: %d%n", getName(), i));
        }
    }
}
