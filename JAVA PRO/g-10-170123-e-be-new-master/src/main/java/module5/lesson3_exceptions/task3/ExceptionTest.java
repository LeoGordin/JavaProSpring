package module5.lesson3_exceptions.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest {

    public static void main(String[] args) {

        first();
        System.out.println("Программа завершила работу успешно.");
    }

    public static void first()  {
        second();
    }

    public static void second()  {
        try {
            third();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void third() throws FileNotFoundException {
        fourth();
    }

    public static void fourth() throws FileNotFoundException {

        FileReader reader = new FileReader("t.txt");
    }
}