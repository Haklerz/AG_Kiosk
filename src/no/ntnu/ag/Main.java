package no.ntnu.ag;

/**
 * The Main class contains the main method for running the application.
 * @author Håkon "Haklerz" Lervik
 * @version 2019.3.25
 */
public class Main {
    /**
     * The entry point for the application.
     */
    public static void main(String[] args) {
        try {
            new TextbasedUserInterface().run();
        } catch (Exception e) {
            System.out.println("We're sorry, something went wrong while running.");
        }
    }
}