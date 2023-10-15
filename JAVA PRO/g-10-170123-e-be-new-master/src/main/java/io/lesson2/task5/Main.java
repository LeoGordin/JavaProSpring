package io.lesson2.task5;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File parent = new File("parent");
        parent.mkdir();

        File level1 = new File("parent/qwe");
        level1.mkdir();
        level1 = new File("parent/asd");
        level1.mkdir();
        level1 = new File("parent/zxc");
        level1.mkdir();

        File level2 = new File("parent/qwe/rty");
        level2.mkdir();
        level2 = new File("parent/qwe/fgh");
        level2.mkdir();
        level2 = new File("parent/qwe/vbn");
        level2.mkdir();

        level2 = new File("parent/asd/rty");
        level2.mkdir();
        level2 = new File("parent/asd/fgh");
        level2.mkdir();
        level2 = new File("parent/asd/vbn");
        level2.mkdir();

        level2 = new File("parent/zxc/rty");
        level2.mkdir();
        level2 = new File("parent/zxc/fgh");
        level2.mkdir();
        level2 = new File("parent/zxc/vbn");
        level2.mkdir();

        File file = new File("parent/zxc/vbn/test.txt");
        file.createNewFile();
        file = new File("parent/asd/test.txt");
        file.createNewFile();
        file = new File("parent/test.txt");
        file.createNewFile();

        deleteDir(parent);
    }

    public static void deleteDir(File file) {

        File[] files = file.listFiles();
        if (files != null) {
            for (File current : files) {
                deleteDir(current);
            }
        }
        file.delete();
    }
}
