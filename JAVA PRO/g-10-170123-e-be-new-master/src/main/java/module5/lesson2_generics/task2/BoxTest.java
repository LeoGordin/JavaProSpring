package module5.lesson2_generics.task2;

import io.lesson2.task4.Cat;

public class BoxTest {

    public static void main(String[] args) {

        Box box = new Box();

        box.putItem("Hello");
        box.putItem(42);
        box.putItem(new Cat(3, "Black", 5.12));

        Object item = box.getItem();
        System.out.println(item);

        int length = ((String) item).length();
        System.out.println("Длина строки - " + length);

        item = box.getItem();
        length = ((String) item).length();
        System.out.println("Длина строки - " + length);
    }
}
