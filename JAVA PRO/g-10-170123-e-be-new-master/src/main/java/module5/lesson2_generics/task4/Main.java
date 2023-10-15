package module5.lesson2_generics.task4;

import io.lesson2.task4.Cat;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List list = new ArrayList();

        list.add("Hello");
        list.add(new Cat(7, "White", 6.54));
        list.add(12);

        String text = (String) list.get(1);
        System.out.println(text);
    }
}