package module5.lesson5_date_time.task5;

import java.time.LocalDateTime;
import java.time.Month;

public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);

        LocalDateTime date1 = LocalDateTime.of(2020, Month.NOVEMBER,
                15, 20, 51, 12, 123456789);

        System.out.println(date1);

        date = date.plusHours(4).minusMinutes(10).plusMonths(2).minusWeeks(1).plusNanos(1);
        System.out.println(date);
    }
}
