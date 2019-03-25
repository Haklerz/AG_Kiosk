package no.ntnu.ag;

/**
 * The Main class contains the main method for running the application.
 */
public class Main {
    public static void main(String[] args) {
        new Tui(new Kiosk()).run();
    }
}