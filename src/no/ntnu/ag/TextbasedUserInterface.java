package no.ntnu.ag;

/**
 * TextbasedUserInterface
 */
public class TextbasedUserInterface {
    private Kiosk kiosk;
    private boolean running;

    public TextbasedUserInterface(Kiosk kiosk) {
        this.addKiosk(kiosk);
    }

    public void run() {
        this.running = true;

        while (running) {
            printCursor();
            Instruction instruction = null;
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