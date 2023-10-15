package module5.lesson2_generics.task2;

import java.util.ArrayList;
import java.util.List;

public class Box {

    private List<Object> items = new ArrayList<>();

    public void putItem(Object item) {
        items.add(item);
    }

    public Object getItem() {
        return items.remove(0);
    }
}