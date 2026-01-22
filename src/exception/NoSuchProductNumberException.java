package exception;

public class NoSuchProductNumberException extends RuntimeException {
    public NoSuchProductNumberException() {
    }

    public NoSuchProductNumberException(String message) {
        super(message);
    }
}
