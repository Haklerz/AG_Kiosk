package no.ntnu.ag.exceptions;

public class IllegalAuthorException extends Exception {
    private static final long serialVersionUID = 1L;

    public IllegalAuthorException(String message) {
        super(message);
    }
}
