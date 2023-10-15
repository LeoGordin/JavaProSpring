package module5.lesson5_date_time.task7;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        //        1. реализовать метод, который принимает год и проверяет на високосность
//        (true, если високосный). isLeapYear в классе GregorianCalendar
//        2. реализовать метод, который принимает дату и выводит в консоль дату,
//        локализованную для Индии.
//        3. реализовать метод, который принимает дату и выводит её в консоль
//        в формате 19-12-22, 19, 353, 11:47 <дата, день месяца, день в году, время>

        System.out.println(isLeapYear(2023));

        Date date = new Date();

        printLocalizedDateIndia(date);
        printFormattedDate(date);
    }

    public static boolean isLeapYear(int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.isLeapYear(year);
    }

    public static void printLocalizedDateIndia(Date date) {
        Locale indianDate = new Locale("IN");
        String formatIndia = String.format(indianDate, "%tc", date);
        System.out.println(formatIndia);
    }

    public static void printFormattedDate(Date date) {
        SimpleDateFormat newDate = new SimpleDateFormat("dd-MM-yy, dd, D, HH:mm");
        System.out.println(newDate.format(date));
    }
}