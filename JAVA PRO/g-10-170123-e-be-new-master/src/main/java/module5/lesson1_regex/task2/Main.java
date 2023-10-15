package module5.lesson1_regex.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {

    public static void main(String[] args) {

        String address = "http://www.examwwwple.comwww";
        Pattern pattern = null;

        try {
            String regex = ".?www.?";
            pattern = Pattern.compile(regex);
        } catch (PatternSyntaxException e) {
            System.out.println(e.getDescription());
            System.out.println(e.getMessage());
            System.out.println(e.getPattern());
        }


        System.out.println("Соответствует ли строка шаблону? - " + pattern.matcher(address).matches());

        Matcher matcher = pattern.matcher(address);

//        System.out.println("Содержит ли строка подстроку, соответствующую шаблону? - " + matcher.find());

        while (matcher.find()) {
            System.out.println("Результат метода start - " + matcher.start());
            System.out.println("Результат метода end - " + matcher.end());
        }
    }
}
