package no.ntnu.ag;

import java.util.Scanner;

/**
 * TextbasedUserInterface
 */
public class TextbasedUserInterface {
    private Kiosk kiosk;
    private boolean running;
    private Scanner input;

    public TextbasedUserInterface(Kiosk kiosk) {
        this.addKiosk(kiosk);
        this.kiosk.init();
        this.input = new Scanner(System.in);
    }

    public void run() {
        this.running = true;

        while (running) {
            printCursor();
            String userInput = input.nextLine();
            Instruction instruction = Instruction.parseInstruction(userInput);

            switch (instruction.getCommand()) {
            case "quit":
                quit();
                break;

            default:
                printUnknownCommand();
                break;
            }
        }
    }

    private void printCursor() {
        System.out.print("\n> ");
    }

    private void printUnknownCommand() {
        System.out.println("Unknown command. Type help for info.");
    }

    private void quit() {
        this.running = false;
        this.input.close();
    }

    /**
     * Points the textbased user interface to a kiosk to interact with.
     * 
     * @param kiosk the kiosk
     */
    private void addKiosk(Kiosk kiosk) {
        if (kiosk != null) {
            this.kiosk = kiosk;
        }
    }
}