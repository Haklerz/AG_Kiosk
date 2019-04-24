package no.ntnu.ag.exceptions;

public class IllegalFieldException extends Exception {
    private static final long serialVersionUID = 1L;

    public IllegalFieldException(String message) {
        super(message);
    }
}
