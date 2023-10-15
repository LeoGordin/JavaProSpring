package module5.lesson2_generics.task8;

public class NumbersTest {

    public static void main(String[] args) {

        Byte b = 10;
        Short s = 200;
        Integer i = 1000;
        Long l = 50L;
        Float f = 12.3f;
        Double d = 150.10;
        String s1 = "56";

        NumberUtils<Byte> utils1 = new NumberUtils<>(b);
        NumberUtils<Short> utils2 = new NumberUtils<>(s);
        NumberUtils<Integer> utils3 = new NumberUtils<>(i);
        NumberUtils<Long> utils4 = new NumberUtils<>(l);
        NumberUtils<Float> utils5 = new NumberUtils<>(f);
        NumberUtils<Double> utils6 = new NumberUtils<>(d);
        // Мы не можем типизировать объект типом, не являющимся наследником Number
//        NumberUtils<String> utils7 = new NumberUtils<>(s1);

        utils1.printIntValue();
        utils2.printIntValue();
        utils3.printIntValue();
        utils4.printIntValue();
        utils5.printIntValue();
        utils6.printIntValue();
//        utils7.printIntValue();
    }
}
