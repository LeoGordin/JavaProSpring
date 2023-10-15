package module5.lesson2_generics.task6;

import io.lesson2.task4.Cat;

public class PairTest {

    public static void main(String[] args) {

        Pair<String, Cat> pair1 = new Pair<>("Cat", new Cat(4, "Gray", 4.8));
        Pair<Double, Double> pair2 = new Pair<>(1.6, 8.4);

        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
    }
}
