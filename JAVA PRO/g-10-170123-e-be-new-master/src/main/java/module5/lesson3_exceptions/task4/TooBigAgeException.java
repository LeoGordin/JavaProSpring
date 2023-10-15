package module5.lesson3_exceptions.task4;

public class TooBigAgeException extends Exception {

    public TooBigAgeException() {
    }

    public TooBigAgeException(String message) {
        super(message);
    }
}
