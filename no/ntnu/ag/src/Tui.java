package no.ntnu.ag.src;

import java.util.Scanner;

/**
 * Represents a Text-based User Interface.
 */
public class Tui {
    private Scanner input;
    private BookRegistry bookRegistry;
    private boolean running;

    public Tui() {
        input = new Scanner(System.in);
        bookRegistry = new BookRegistry();
        bookRegistry.fillDummies();
    }

    public void run() {
        this.running = true;
        while(running) {
            getInput();
        }
        this.quit();
    }

    private Instruction getInput() {
        System.out.print(">");
        Instruction instruction = new Instruction(this.input.nextLine());
        return instruction;
    }

    private void quit() {
        this.input.close();
        this.running = false;
    }
}