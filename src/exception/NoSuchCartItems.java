package exception;

public class NoSuchCartItems extends RuntimeException {
    public NoSuchCartItems() {}

    public NoSuchCartItems(String message) {
        super(message);
    }
}
