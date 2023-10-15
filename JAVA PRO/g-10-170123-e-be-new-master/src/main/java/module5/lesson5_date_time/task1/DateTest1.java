package module5.lesson5_date_time.task1;

import java.util.Date;

public class DateTest1 {

    public static void main(String[] args) {

        Date date = new Date();

        System.out.println(date);

        date.setTime(17369425841556L);

        System.out.println(date);

        Date current = new Date();

        System.out.println(current);

        current.setTime(3000 + current.getTime());

        System.out.println(current);
    }
}
