package exception;

public class NoSuchRemovedProductId extends RuntimeException {
    public NoSuchRemovedProductId() {}

    public NoSuchRemovedProductId(String message) {
        super(message);
    }
}
