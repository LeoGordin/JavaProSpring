package module6.lesson3.task2;

import java.io.FileWriter;

public class FileService {

    public static synchronized void writeToFile(String text) {
        try (FileWriter writer = new FileWriter("test.txt", true)) {
            writer.write(text);
        } catch (Exception e) {
            System.out.println("Ошибка!");
        }
    }
}
