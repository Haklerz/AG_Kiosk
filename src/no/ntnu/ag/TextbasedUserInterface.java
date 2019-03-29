package no.ntnu.ag;

import java.util.Scanner;
import java.util.Iterator;
import no.ntnu.ag.literature.*;

/**
 * TextbasedUserInterface
 * <ul>
 * <li>Det skal være mulig å registrere lesestoff av alle typer definert
 * ovenfor.
 * <li>Det skal være mulig å skrive ut innholdet i hele registeret.
 * <li>Det skal være mulig å søke i registeret på tittel og utgiver for å finne
 * ett konkret lesestoff.
 * <li>Det skal være mulig å søke i registeret etter alt lesestoff fra en
 * bestemt utgiver.
 * <li>Det skal være mulig å gjøre om en enkeltstående bok om til en serie.
 * <li>I tillegg kan dere utvide applikasjonen med funksjonalitet dere mener
 * hører hjemme i en slik applikasjon som for eksempel mer avansert søk, bygge
 * inn salgs-støtte (kassa-apparat (POS)) osv.
 * </ul>
 * 
 * new list find add remove
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
            case "list":
                list();
                break;

            case "quit":
                quit();
                break;

            default:
                printUnknownCommand();
                break;
            }
        }
    }

    private void list() {
        Iterator<Literature> literatureIterator = registry.getLiteratureIterator();
        while (literatureIterator.hasNext()) {
            Literature literature = literatureIterator.next();
            if (literature instanceof Book) {

            } else if (literature instanceof Journal) {

            } else if (literature instanceof Newspaper) {
            
            } else if (literature instanceof Magazine) {

            } else if (literature instanceof BookSeries) {
                
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
        System.out.println("Thank you for using kiosk v" + 0.6 + ".");
        this.running = false;
        this.input.close();
    }
}