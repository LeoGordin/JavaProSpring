package io.lesson2.task4;

import java.io.*;

public class ObjectTest {

    public static void main(String[] args) {

        File file = new File("cat.txt");
        Cat cat1 = new Cat(3, "Black", 4.65);
        Cat cat2 = new Cat(5, "Gray", 5.12);

        try (OutputStream fileOut = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            file.createNewFile();

            out.writeObject(cat1);
            out.writeObject(cat2);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
            e.printStackTrace();
        }
    }
}
