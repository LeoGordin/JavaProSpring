package module5.lesson5_date_time.task6;

import java.time.*;

public class ZonedDateTimeTest {

    public static void main(String[] args) {

        ZonedDateTime date = ZonedDateTime.now();
        System.out.println(date);

        ZoneId zoneId = ZoneId.systemDefault();

        ZonedDateTime date1 = ZonedDateTime.of(2015, 5, 30,
                2, 10, 15, 123, zoneId);

        System.out.println(date1);

        LocalDate localDate = LocalDate.of(2010, Month.JANUARY, 5);

        LocalTime localTime = LocalTime.of(10, 10, 10, 10);

        ZonedDateTime date2 = ZonedDateTime.of(localDate, localTime, zoneId);
        System.out.println(date2);
    }
}
