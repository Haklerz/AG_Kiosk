package no.ntnu.ag.exceptions;

public class IllegalGenreException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public IllegalGenreException(String message) {
        super(message);
    }
}
