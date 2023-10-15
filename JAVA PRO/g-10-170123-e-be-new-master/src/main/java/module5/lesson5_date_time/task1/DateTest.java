package module5.lesson5_date_time.task1;

import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws InterruptedException {

        // Создаём объект текущего момента времени
        Date currentDate = new Date();

        Thread.sleep(200);

        Date currentDate1 = new Date();

        System.out.println(currentDate);
        System.out.println(currentDate1);
        System.out.println(currentDate.getTime());
        System.out.println(currentDate1.getTime());
    }
}
