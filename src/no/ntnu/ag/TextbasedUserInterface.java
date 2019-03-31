package no.ntnu.ag;

import java.util.Scanner;
import java.util.HashMap;
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
 * @version 2019.3.27
 * @author Håkon "Haklerz" Lervik
 */
public class TextbasedUserInterface {
    private static final int INFO_MARGIN = 16;
    private HashMap<String, String> text;
    private LiteratureRegistry registry;
    private Literature currentLiterature;
    private boolean running;
    private Scanner input;

    /**
     * 
     */
    public TextbasedUserInterface() {
        this.registry = new LiteratureRegistry();
        this.registry.fillDummies(); // temp.
        this.setCurrentLiterature(null);
        this.input = new Scanner(System.in);
        this.text = new HashMap<>();
        this.fillText();
    }

    /**
     * 
     */
    private void fillText() {
        this.text.put("UNKNOWN_CMD", "Unknown command. Type help for info.\n");
        this.text.put("QUIT_MSG", "Shutting down. Thank you for using the kiosk.");
    }

    /**
     * @return the currentLiterature
     */
    private Literature getCurrentLiterature() {
        return currentLiterature;
    }

    /**
     * @param literature the literature to set as current
     */
    private void setCurrentLiterature(Literature literature) {
        if (literature != null)
            this.currentLiterature = literature;
    }

    /**
     * 
     */
    public void run() {
        this.running = true;

        while (running) {
            printCursor();
            String userInput = input.nextLine();
            Instruction instruction = Instruction.parseInstruction(userInput);

            switch (instruction.getCommand()) {
            case MOVE:
                break;

            case FIND:
                find(instruction.getArgument());
                break;

            case LIST:
                list();
                break;

            case QUIT:
                quit();
                break;

            case UNKNOWN:
                print("UNKNOWN_CMD");
                break;
            }
        }
    }

    /**
     * 
     * @param info
     */
    private void print(String info) {
        System.out.print(this.text.get(info));
    }

    /**
     * TODO: Refactor this ugly thing.
     * 
     * @param argument
     */
    private void find(String argument) {
        Iterator<Literature> literatureIterator = registry.getLiteratureIterator();
        Literature foundLiterature = null;
        while (literatureIterator.hasNext()) {
            Literature literature = literatureIterator.next();
            if (!(literature instanceof BookSeries)) {
                String literatureDetails = literature.getTitle() + " " + literature.getPublisher();
                if (literatureDetails.toLowerCase().contains(argument.toLowerCase())) {
                    foundLiterature = literature;
                }
            } else {
                Iterator<Book> bookIterator = ((BookSeries) literature).getBookIterator();
                while (bookIterator.hasNext()) {
                    Book book = bookIterator.next();
                    String BookDetails = book.getTitle() + " " + book.getPublisher();
                    if (BookDetails.toLowerCase().contains(argument.toLowerCase())) {
                        foundLiterature = book;
                    }
                }
            }
        }
        printLiteratureDetails(foundLiterature);
    }

    /**
     * 
     */
    private void list() {
        Iterator<Literature> literatureIterator = registry.getLiteratureIterator();
        while (literatureIterator.hasNext()) {
            Literature literature = literatureIterator.next();
            printLiteratureDetails(literature);
            if (literatureIterator.hasNext()) {
                System.out.println();
            }
        }
    }

    /**
     * 
     * @param literature
     */
    private void printLiteratureDetails(Literature literature) {
        if (literature instanceof Book) {
            Book book = (Book) literature;
            System.out.println(
                padString("Book") + book.getTitle() + "\n" + 
                padString("Publisher") + book.getPublisher() + "\n" +
                padString("Author") + book.getAuthor() + "\n" + 
                padString("Edition") + book.getEdition()
            );
        } else if (literature instanceof Journal) {
            Journal journal = (Journal) literature;
            System.out.println(
                padString("Journal") + journal.getTitle() + "\n" + 
                padString("Publisher") + journal.getPublisher()+ "\n" +
                padString("Field") + journal.getField() + "\n" + 
                padString("Editions/year") + journal.getEditions()
            );
        } else if (literature instanceof Newspaper) {
            Newspaper newspaper = (Newspaper) literature;
            System.out.println(
                padString("Newspaper") + newspaper.getTitle() + "\n" +
                padString("Publisher") + newspaper.getPublisher() + "\n" +
                padString("Editions/year") + newspaper.getEditions()
            );
        } else if (literature instanceof Magazine) {
            Magazine magazine = (Magazine) literature;
            System.out.println(
                padString("Magazine") + magazine.getTitle() + "\n" +
                padString("Publisher") + magazine.getPublisher() + "\n" +
                padString("Genre") + magazine.getGenre() + "\n" +
                padString("Editions/year") + magazine.getEditions()
            );
        } else if (literature instanceof BookSeries) {
            BookSeries bookSeries = (BookSeries) literature;
            System.out.println(
                padString("Series") + bookSeries.getTitle() + "\n" +
                padString("Published by") + bookSeries.getPublisher() + "\n"
            );
            Iterator<Book> bookIterator = bookSeries.getBookIterator();
            while (bookIterator.hasNext()) {
                Book book = bookIterator.next();
                System.out.println(
                    padString("    Book") + book.getTitle() + "\n" +
                    padString("    Author") + book.getAuthor() + "\n" +
                    padString("    Edition") + book.getEdition()
                );
                if (bookIterator.hasNext()) {
                    System.out.println();
                }
            }
        }
    }

    /**
     * 
     */
    private String padString(String text) {
        int n = INFO_MARGIN - text.length();
        String paddedString = text;
        for (int i = 0; i < n; i++) {
            paddedString += " ";
        }
        return paddedString;
    }

    /**
     * 
     */
    private void printCursor() {
        System.out.print("\n> ");
    }

    /**
     * 
     */
    private void quit() {
        print("QUIT_MSG");
        this.running = false;
        this.input.close();
    }
}