package module5.lesson2_generics.task5;

public class BoxTest {

    public static void main(String[] args) {

        Box<String> box1 = new Box<>();
        Box<Integer> box2 = new Box<>();

        box1.putItem("Java");
        box2.putItem(10);

        System.out.println(box1.getItem().substring(0, 2));
        System.out.println(box2.getItem().floatValue());
    }
}
