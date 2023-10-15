package io.lesson2.task4;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class CatReadTest {

    public static void main(String[] args) {

        try (InputStream fileIn = new FileInputStream("cat.txt");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            Cat cat1 = (Cat) in.readObject();
            Cat cat2 = (Cat) in.readObject();

            System.out.println(cat1);
            System.out.println(cat2);
        } catch (Exception e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
