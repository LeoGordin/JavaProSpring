package module6.lesson3.task1;

import java.io.FileWriter;

public class MyThread extends Thread {

    @Override
    public void run() {
        // Записать в файл какую-то информацию 100 раз
        try (FileWriter writer = new FileWriter("test.txt", true)) {
            for (int i = 0; i < 100; i++) {
                // Alpha: 54
                writer.write(String.format("%s: %d%n", getName(), i));
                Thread.sleep(100);
            }
        } catch (Exception e) {
            System.out.println("Ошибка!");
        }
    }
}
