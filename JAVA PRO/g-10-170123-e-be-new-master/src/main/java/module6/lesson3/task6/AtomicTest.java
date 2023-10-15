package module6.lesson3.task6;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) {

        AtomicInteger atomic = new AtomicInteger(0);

        System.out.println("Изначальное значение - " + atomic);

        // Устанавливаем значение
        atomic.set(5);
        System.out.println("Новое значение - " + atomic);

        // Метод устанавливает значение, переданное вторым параметром
        // в том случае, если текущее значение равно первому параметру
        boolean result = atomic.compareAndSet(7, 9);
        System.out.println("Результат установки значения - " + result);
        System.out.println("Значение - " + atomic);

        result = atomic.compareAndSet(5, 9);
        System.out.println("Результат установки значения - " + result);
        System.out.println("Значение - " + atomic);

        // Метод увеличивает текущее значение на переданное значение
        // и возвращает новое значение
        int newValue = atomic.addAndGet(3);
        System.out.println("Полученное значение - " + newValue);
        System.out.println("Значение атомика - " + atomic);

        // Возвращает текущее значение атомика,
        // а потом увеличивает его на переданное значение
        newValue = atomic.getAndAdd(3);
        System.out.println("Полученное значение - " + newValue);
        System.out.println("Значение атомика - " + atomic);

        // Увеличивает значение на 1 и возвращает новое значение
        newValue = atomic.incrementAndGet();
        System.out.println("Полученное значение - " + newValue);
        System.out.println("Значение атомика - " + atomic);

        // Возвращает текущее значение, а потом увеличивает его на 1
        newValue = atomic.getAndIncrement();
        System.out.println("Полученное значение - " + newValue);
        System.out.println("Значение атомика - " + atomic);

        // Уменьшает значение на 1 и возвращает новое значение
        newValue = atomic.decrementAndGet();
        System.out.println("Полученное значение - " + newValue);
        System.out.println("Значение атомика - " + atomic);

        // Возвращает текущее значение, а потом уменьшает его на 1
        newValue = atomic.getAndDecrement();
        System.out.println("Полученное значение - " + newValue);
        System.out.println("Значение атомика - " + atomic);

        // Возвращает старое значение, а потом устанавливает переданное значение
        newValue = atomic.getAndSet(30);
        System.out.println("Полученное значение - " + newValue);
        System.out.println("Значение атомика - " + atomic);
    }
}