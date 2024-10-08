package lk.ijse.possystemspring.Exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
        super();
    }
    public OrderNotFoundException(String message) {
        super(message);
    }
    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
