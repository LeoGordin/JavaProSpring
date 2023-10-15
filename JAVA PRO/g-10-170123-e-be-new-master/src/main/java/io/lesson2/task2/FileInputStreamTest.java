package io.lesson2.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {

    public static void main(String[] args) {

        // 1 способ - передать в конструктор имя файла
//        InputStream in = new FileInputStream("test.txt");

        // 2 способ - передать в конструктор объект типа File
        File file = new File("test.txt");

        try (InputStream in = new FileInputStream(file)) {

            System.out.println("Байт осталось - " + in.available());

            int data = in.read();

            while (data != -1) {
                System.out.print((char) data);
                if ('!' == (char) data) {
                    in.skip(8);
                }
                data = in.read();
            }
        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }
//        finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    System.out.println("Ошибка ввода-вывода.");
//                }
//            }
//        }
    }
}
