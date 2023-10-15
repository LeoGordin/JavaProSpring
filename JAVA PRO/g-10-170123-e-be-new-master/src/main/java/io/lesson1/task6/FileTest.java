package io.lesson1.task6;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) throws IOException {

        File file = new File("test.txt");
        File file1 = new File("picture.jpg");

        System.out.println("Существует ли file? - " + file.exists());
        System.out.println("Существует ли file1? - " + file1.exists());

        boolean isFileCreated = file1.createNewFile();

        System.out.println("Был ли создан файл? - " + isFileCreated);
        System.out.println("Существует ли file1? - " + file1.exists());

        boolean isFileDeleted = file1.delete();

        System.out.println("Был ли удалён файл? - " + isFileDeleted);
        System.out.println("Существует ли file1? - " + file1.exists());

        File dir = new File("Test Dir");
        System.out.println("Существует ли папка? - " + dir.exists());
        dir.mkdir();
        System.out.println("Существует ли папка? - " + dir.exists());

        System.out.println("dir - это папка? - " + dir.isDirectory());
        System.out.println("dir - это файл? - " + dir.isFile());

        File dir1 = new File("Dir 1\\Dir 2\\Dir 3\\Dir 4");
        dir1.mkdirs();
        System.out.println("Существует ли папка dir1? - " + dir1.exists());
    }
}
