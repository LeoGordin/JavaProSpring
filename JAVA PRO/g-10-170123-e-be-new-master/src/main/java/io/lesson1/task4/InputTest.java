package io.lesson1.task4;

import java.io.*;

public class InputTest {

    public static void main(String[] args) throws IOException {

        InputStream stream = new FileInputStream("test.txt");
        Reader reader = new InputStreamReader(stream);

        reader.skip(13);

        int data = reader.read();

        while (data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }

        stream.close();
    }
}
