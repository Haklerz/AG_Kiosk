package no.ntnu.ag;

import java.util.Scanner;

/**
 * TextbasedUserInterface
 * 
 * Det skal være mulig å registrere lesestoff av alle typer definert ovenfor.
 * Det skal være mulig å skrive ut innholdet i hele registeret.
 * Det skal være mulig å søke i registeret på tittel og utgiver for å finne ett konkret lesestoff.
 * Det skal være mulig å søke i registeret etter alt lesestoff fra en bestemt utgiver.
 * Det skal være mulig å gjøre om en enkeltstående bok om til en serie.
 * I tillegg kan dere utvide applikasjonen med funksjonalitet dere mener hører hjemme i en slik
 * applikasjon som for eksempel mer avansert søk, bygge inn salgs-støtte (kassa-apparat (POS)) osv.
 * 
 * new
 * list
 * find
 * add
 * remove
 * 
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public class TextbasedUserInterface {
    private LiteratureRegistry registry;
    private boolean running;
    private Scanner input;

    public TextbasedUserInterface() {
        this.registry = new LiteratureRegistry();
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
}