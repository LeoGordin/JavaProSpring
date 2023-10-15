package module5.lesson1_regex.task1;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        // Проверить, содержит ли строка сочетание "www"

        String address = "www.example.com";
        String address1 = "http://www.example.com";
        String address2 = "http://example.com";
        String address3 = "http://www";
        String address4 = "http://www.example.com";
        String address5 = "http://wwwexample.com";
        String address6 = "http://www[]example.com";
        String address7 = "/www.example.com";
        String address8 = "www.example.com";
        String address9 = "/www.";
        String address10 = "/www";

        System.out.printf("Проверяемая строка - %s, результат - %b%n", address, checkAddress(address));
        System.out.printf("Проверяемая строка - %s, результат - %b%n", address1, checkAddress(address1));
        System.out.printf("Проверяемая строка - %s, результат - %b%n", address2, checkAddress(address2));
        System.out.printf("Проверяемая строка - %s, результат - %b%n", address3, checkAddress(address3));
        System.out.printf("Проверяемая строка - %s, результат - %b%n", address4, checkAddress(address4));
        System.out.printf("Проверяемая строка - %s, результат - %b%n", address5, checkAddress(address5));
        System.out.printf("Проверяемая строка - %s, результат - %b%n", address6, checkAddress(address6));
        System.out.printf("Проверяемая строка - %s, результат - %b%n", address7, checkAddress(address7));
        System.out.printf("Проверяемая строка - %s, результат - %b%n", address8, checkAddress(address8));
        System.out.printf("Проверяемая строка - %s, результат - %b%n", address9, checkAddress(address9));
        System.out.printf("Проверяемая строка - %s, результат - %b%n", address10, checkAddress(address10));
    }

    public static boolean checkAddress(String address) {

//        String regex = ".*www.*";
//        String regex = ".*[.]example[.].*";
//        String regex = ".*\\[\\].*";
        String regex = ".?www.+";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Используемый шаблон - " + pattern.pattern());
        boolean result = pattern.matcher(address).matches();
        return result;
    }
}