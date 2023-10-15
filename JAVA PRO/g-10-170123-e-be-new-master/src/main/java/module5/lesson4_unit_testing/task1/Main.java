package module5.lesson4_unit_testing.task1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] result = ArrayUtils.getArrayBySize(5);
        System.out.println(Arrays.toString(result));

        result = ArrayUtils.getArrayBySize(0);
        System.out.println(Arrays.toString(result));

        result = ArrayUtils.getArrayBySize(-3);
    }
}
