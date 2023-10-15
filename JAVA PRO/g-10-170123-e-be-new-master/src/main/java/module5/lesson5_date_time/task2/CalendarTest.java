package module5.lesson5_date_time.task2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar);

        int result = calendar.get(Calendar.YEAR);
        System.out.println("Текущий год - " + result);

        result = calendar.get(Calendar.WEEK_OF_MONTH);
        System.out.println("Номер недели в этом месяце - " + result);

        calendar.set(2020, Calendar.SEPTEMBER, 12, 14, 28, 53);

        result = calendar.get(Calendar.MINUTE);
        System.out.println("Минуты - " + result);

        calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
        result = calendar.get(Calendar.MONTH);
        System.out.println("Месяц - " + result);

        calendar.add(Calendar.YEAR, 3);
        result = calendar.get(Calendar.YEAR);
        System.out.println("Новое значение года - " + result);

        calendar.add(Calendar.MONTH, -3);
        System.out.println("Новое значение месяца - " + calendar.get(Calendar.MONTH));
        System.out.println("Новое значение года - " + calendar.get(Calendar.YEAR));

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String formattedDate = formatter.format(calendar.getTime());
        System.out.println("Отформатированная дата - " + formattedDate);
    }
}
