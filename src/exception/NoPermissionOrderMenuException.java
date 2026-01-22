package exception;

public class NoPermissionOrderMenuException extends RuntimeException {
    public NoPermissionOrderMenuException() {
    }

    public NoPermissionOrderMenuException(String message) {
        super(message);
    }
}
