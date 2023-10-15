package module5.lesson5_date_time.task1;

import java.util.Date;

public class DateTest2 {

    public static void main(String[] args) {

        Date date1 = new Date(100, 4, 12);
        Date current = new Date();
        Date date2 = new Date(110, 9, 27);
        Date date3 = new Date(100, 4, 12);

        System.out.println(date1);
        System.out.println(current);
        System.out.println(date2);

        boolean result = date1.before(date2);
        System.out.println("Дата 1 раньше даты 2 - " + result);

        result = date1.after(date2);
        System.out.println("Дата 1 после даты 2 - " + result);

        result = date1.before(current);
        System.out.println("Дата 1 раньше текущей - " + result);

        int result1 = date1.compareTo(date3);
        System.out.println("Результат date1.compareTo(date3) - " + result1);

        result1 = date1.compareTo(current);
        System.out.println("Результат date1.compareTo(current) - " + result1);

        System.out.println(date1.equals(date3));
        System.out.println(current.equals(date2));
    }
}
