package module5.lesson4_unit_testing.task1;

public class ArrayUtils {

    // 5 -> [1, 2, 3, 4, 5]
    public static int[] getArrayBySize(int size) {
        if (size < 0) {
            throw new RuntimeException("Индекс массива не может быть отрицательным");
        }
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}