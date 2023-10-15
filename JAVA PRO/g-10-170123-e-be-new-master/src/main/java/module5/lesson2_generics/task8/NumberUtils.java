package module5.lesson2_generics.task8;

public class NumberUtils<T extends Number> {

    private T value;

    public NumberUtils(T value) {
        this.value = value;
    }

    public void printIntValue() {
        System.out.println(value.intValue());
    }
}
