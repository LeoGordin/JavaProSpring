package module5.lesson5_date_time.task4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateTest {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate date1 = LocalDate.of(2020, 5, 26);
        System.out.println(date1);

        LocalDate date2 = LocalDate.of(2010, Month.APRIL, 20);
        System.out.println(date2);

        int result = date.getDayOfYear();
        System.out.println("Порядковый номер дня в году - " + result);

        result = date.getMonthValue();
        System.out.println("Номер месяца - " + result);

        Month month = date.getMonth();
        System.out.println("Текущий месяц" + month);

        System.out.println("Номер месяца" + month.getValue());
        System.out.println("Первый месяц текущего квартала" + month.firstMonthOfQuarter());

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("Текущий день недели - " + dayOfWeek);

        date = date.plusWeeks(2);

        System.out.println(date);

        date = date.minusMonths(3);

        System.out.println(date);

        LocalDate date3 = LocalDate.of(2023, Month.JULY, 31);
        date3 = date3.minusMonths(1);
        System.out.println(date3);
    }
}
