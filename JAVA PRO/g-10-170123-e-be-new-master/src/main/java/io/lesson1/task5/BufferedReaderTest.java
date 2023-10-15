package io.lesson1.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderTest {

    public static void main(String[] args) throws IOException {

        Reader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String input = br.readLine();

        System.out.println(input);
    }
}
