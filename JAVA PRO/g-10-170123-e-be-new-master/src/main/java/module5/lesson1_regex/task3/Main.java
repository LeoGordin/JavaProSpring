package module5.lesson1_regex.task3;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String text = "Hello7World!45I954study1Java.";

        // * - любое количество символов
        // + - как минимум 1 символ или более
        // ? - либо ни одного, либо 1 символ
//        String regex = "[A-Za-z]+";
//        String regex = "[0-9]+";
//        String regex = "\\d+";
//        String regex = "\\d{1,3}";
        String regex = "[0-9]{1,3}";
        Pattern pattern = Pattern.compile(regex);

        String[] words = pattern.split(text);

        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
