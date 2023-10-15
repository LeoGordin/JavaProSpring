package module5.lesson4_unit_testing.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    // 1. Проверим внутреннее содержание массива.
    //    (значение какой-то из ячеек наугад).
    // 2. Проверим, не возвращает ли метод null.
    // 3. Проверим, выдаёт ли метод ошибку при некорректных значениях.
    // 4. Проверим, возвращает ли метод массив нужного размера.

    private int[] testedArray;

    @BeforeEach
    public void init() {
        testedArray = ArrayUtils.getArrayBySize(7);
    }

    @Test
    public void checkArrayInnerValue() {
        int expected = 4;
        int actual = testedArray[3];
        assertEquals(expected, actual, "Проверка внутреннего содержания массива.");
    }

    @Test
    public void checkIfArrayIsNotNull() {
        int[] actual = testedArray;
        assertNotNull(actual, "Метод вернул null вместо массива.");
    }

    @Test
    public void checkCorrectArraySize() {
        int expected = 7;
        int actual = testedArray.length;
        assertEquals(expected, actual, "Размер массива не соответствует ожидаемому.");
    }

    @Test
    public void exceptionIfIndexUnderZero() {
        try {
            ArrayUtils.getArrayBySize(-1);
        } catch (RuntimeException e) {
            return;
        }
        fail();
    }
}