package module5.lesson2_generics.task1;

import io.lesson2.task4.Cat;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        Object obj1 = "Hello";
        Object obj2 = new Cat(4, "Black", 5.4);
        Object obj3 = 5;
    }
}
