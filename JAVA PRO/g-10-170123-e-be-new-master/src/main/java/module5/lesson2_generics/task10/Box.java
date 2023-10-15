package module5.lesson2_generics.task10;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> fruits = new ArrayList<>();

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0;
        }
        return fruits.size() * fruits.get(0).getWeight();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public boolean compare(Box<? extends Fruit> box) {
        return getWeight() == box.getWeight();
    }

    public void pour(Box<T> box) {
        box.fruits.addAll(fruits);
        fruits.clear();
    }
}
