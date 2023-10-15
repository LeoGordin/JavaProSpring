package module5.lesson2_generics.task7;

import io.lesson2.task4.Cat;

public class Main {

    public static void main(String[] args) {

        print("Hello World!");
        print(255);
        print(new Cat(9, "Green", 3.98));
    }

    public static <T> void print(T item) {
        System.out.println(item);
    }

    // Если бы не было дженериков,
    // то нам бы пришлось писать отдельный метод для каждого типа
//    public static void print(String item) {
//        System.out.println(item);
//    }
//
//    public static void print(Integer item) {
//        System.out.println(item);
//    }
//
//    public static void print(Cat item) {
//        System.out.println(item);
//    }
}
