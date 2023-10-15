package module5.lesson3_exceptions.task5;

public class IndexForArrayIsIncorrectException extends Exception {
    public IndexForArrayIsIncorrectException() {
    }

    public IndexForArrayIsIncorrectException(String message, Throwable cause) {
        super(message, cause);
    }
}
