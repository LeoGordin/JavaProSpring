package module5.lesson2_generics.task10;

public class Main {

    public static void main(String[] args) {

        //        a. Есть классы Fruit (абстрактный), его наследники —->
//        Apple, Orange;(больше фруктов не надо)
//        b. Класс Box в который можно складывать фрукты, коробки типизируются по типу фрукта,
//        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//        d. Сделать метод getWeight() который высчитывает вес коробки,
//        зная количество фруктов и вес одного фрукта
//        (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        e. Внутри класса коробка сделать метод compare,
//        который позволяет сравнить текущую коробку с той,
//        которую подадут в compare в качестве параметра, true - если их веса равны,
//        false в противном случае
//        (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//        f. Написать метод, который позволяет пересыпать фрукты из текущей
//        коробки в другую коробку
//        (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
//        соответственно в текущей коробке фруктов не остается,
//        а в другую перекидываются объекты, которые были в этой коробке;
//        g. Не забываем про метод добавления фрукта в коробку.

        Box<Apple> apples = new Box<>();
        Box<Orange> oranges = new Box<>();

        apples.addFruit(new Apple());
        apples.addFruit(new Apple());
        apples.addFruit(new Apple());

        // Не можем в коробку яблок добавить апельсин (по условию задачи)
//        apples.addFruit(new Orange());

        oranges.addFruit(new Orange());
        oranges.addFruit(new Orange());
        oranges.addFruit(new Orange());

        System.out.println("Вес коробок:");
        System.out.println(apples.getWeight());
        System.out.println(oranges.getWeight());

        System.out.println("Сравниваем вес коробок:");
        // По условию задачи можем сравнивать коробку яблок с коробкой апельсинов
        System.out.println(apples.compare(oranges));

        System.out.println("Добавляем ещё фруктов в коробки и снова сравниваем вес:");
        oranges.addFruit(new Orange());
        apples.addFruit(new Apple());
        apples.addFruit(new Apple());
        apples.addFruit(new Apple());

        System.out.println(apples.compare(oranges));

        // По условию задачи не можем яблоки высыпать в коробку с апельсинами
//        apples.pour(oranges);

        Box<Apple> apples1 = new Box<>();

        apples1.addFruit(new Apple());
        apples1.addFruit(new Apple());

        System.out.println("Вес двух коробок с яблоками:");
        System.out.println(apples.getWeight());
        System.out.println(apples1.getWeight());

        System.out.println("Пересыпаем яблоки и снова выводим вес коробок:");
        apples1.pour(apples);

        System.out.println(apples.getWeight());
        System.out.println(apples1.getWeight());
    }
}