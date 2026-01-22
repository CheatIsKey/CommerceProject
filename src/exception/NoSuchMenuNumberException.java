package exception;

public class NoSuchMenuNumberException extends RuntimeException {
    public NoSuchMenuNumberException() {
    }

    public NoSuchMenuNumberException(String message) {
        super(message);
    }
}
