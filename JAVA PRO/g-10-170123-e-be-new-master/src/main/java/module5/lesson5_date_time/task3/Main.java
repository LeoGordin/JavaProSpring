package module5.lesson5_date_time.task3;

import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Locale locale = new Locale("de");

        Date current = new Date();

        String date = String.format(locale, "%tc", current);

        System.out.println("Локализованная дата - " + date);
    }
}
