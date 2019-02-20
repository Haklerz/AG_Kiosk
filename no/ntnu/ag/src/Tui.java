package no.ntnu.ag.src;

import java.util.Scanner;

/**
 * Represents a Text-based User Interface.
 */
public class Tui {
    private Scanner input;
    private BookRegistry bookRegistry;
    //private Book currantBook;

    public static void main(String[] args) {
        Tui tui = new Tui();
        tui.getInput();
        tui.getInput();
        tui.shutdown();
    }

    public Tui() {
        input = new Scanner(System.in);
        bookRegistry = new BookRegistry();
        bookRegistry.fillDummies();
    }

    public void getInput() {
        System.out.print(">");
        String command = input.next();
        command = command.toLowerCase();
        System.out.println();
    }

    public void shutdown() {
        this.input.close();
    }
}