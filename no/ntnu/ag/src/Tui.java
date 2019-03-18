package no.ntnu.ag.src;

import java.util.Scanner;

public class Tui {
    private Kiosk kiosk;
    private boolean running;
    private Scanner input;

    public Tui(Kiosk kiosk) {
        this.kiosk = kiosk;
        this.input = new Scanner(System.in);
    }

    private void processRequest(String request) {
        Instruction instruction = Instruction.parseInstruction(request);
        switch (instruction.getCommand()) {
        case "list":
            kiosk.list();
            break;

        case "help":
            kiosk.help();
            break;

        case "find":
            kiosk.find(instruction.getArgument());
            break;

        case "remove":
            kiosk.remove(instruction.getArgument());
            break;

        default:
            kiosk.unknownCommand();
            break;
        }
    }

    public void run() {
        running = true;
        while (running) {
            String request = input.nextLine();
            processRequest(request);
            String response = kiosk.getResponse();
            System.out.println(response);
        }
    }
}