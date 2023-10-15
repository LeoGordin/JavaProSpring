package module5.lesson3_exceptions.task4;

public class TooSmallAgeException extends RuntimeException {

    public TooSmallAgeException() {

    }

    public TooSmallAgeException(String s) {
        super(s);
    }
}