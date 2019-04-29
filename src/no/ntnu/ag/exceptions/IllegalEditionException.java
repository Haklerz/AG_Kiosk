package no.ntnu.ag.exceptions;

public class IllegalEditionException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public IllegalEditionException(String message) {
        super(message);
    }
}
