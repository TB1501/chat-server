package hr.vsite.java.chatserver;

public class GroupValidationException extends RuntimeException {

    public GroupValidationException(String message) {
        super(message);
    }

    public GroupValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
