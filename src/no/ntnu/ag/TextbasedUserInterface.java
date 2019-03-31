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
 * @version 2019.3.27
 * @author Håkon "Haklerz" Lervik
 */
public class TextbasedUserInterface {
    private static final int INFO_MARGIN = 16;
    private LiteratureRegistry registry;
    private Literature currentLiterature;
    private boolean running;
    private Scanner input;

    public TextbasedUserInterface() {
        this.registry = new LiteratureRegistry();
        this.registry.fillDummies();
        this.currentLiterature = null;
        this.input = new Scanner(System.in);
    }

    public void run() {
        this.running = true;

        while (running) {
            printCursor();
            String userInput = input.nextLine();
            Instruction instruction = Instruction.parseInstruction(userInput);

            switch (instruction.getCommand()) {
            case "find":
                find(instruction.getArgument());
                break;

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

    private void printLiteratureDetails(Literature literature) {
        if (literature instanceof Book) {
            printBookDetails((Book) literature);
        } else if (literature instanceof Journal) {
            printJournalDetails((Journal) literature);
        } else if (literature instanceof Newspaper) {
            printNewspaperDetails((Newspaper) literature);
        } else if (literature instanceof Magazine) {
            printMagazineDetails((Magazine) literature);
        } else if (literature instanceof BookSeries) {
            BookSeries bookSeries = (BookSeries) literature;
            printBookSeriesDetails(bookSeries);
            Iterator<Book> bookIterator = bookSeries.getBookIterator();
            while (bookIterator.hasNext()) {
                Book book = bookIterator.next();
                printBookDetailsIndent(book);
                if (bookIterator.hasNext()) {
                    System.out.println();
                }
            }
        }
    }

    private void printBookSeriesDetails(BookSeries bookSeries) {
        System.out.println("Series         " + bookSeries.getTitle() + "\n" + "Published by   "
                + bookSeries.getPublisher() + "\n");
    }

    private void printMagazineDetails(Magazine magazine) {
        System.out.println("Magazine       " + magazine.getTitle() + "\n" + "Publisher      " + magazine.getPublisher()
                + "\n" + "Genre          " + magazine.getGenre() + "\n" + "Editions/year  " + magazine.getEditions());
    }

    private void printNewspaperDetails(Newspaper newspaper) {
        System.out.println("Newspaper      " + newspaper.getTitle() + "\n" + "Publisher      "
                + newspaper.getPublisher() + "\n" + "Editions/year  " + newspaper.getEditions());
    }

    private void printJournalDetails(Journal journal) {
        System.out.println("Journal        " + journal.getTitle() + "\n" + "Publisher      " + journal.getPublisher()
                + "\n" + "Field          " + journal.getField() + "\n" + "Editions/year  " + journal.getEditions());
    }

    private void printBookDetailsIndent(Book book) {
        System.out.println("    Book           " + book.getTitle() + "\n" + "    Author         " + book.getAuthor()
                + "\n" + "    Edition        " + book.getEdition());
    }

    private void printBookDetails(Book book) {
        System.out.println(
            padString("Book") + book.getTitle() + "\n" +
            padString("Publisher") + book.getPublisher() + "\n" +
            padString("Author") + book.getAuthor() + "\n" +
            padString("Edition") + book.getEdition()
        );
    }

    private String padString(String text) {
        int n = INFO_MARGIN - text.length();
        String paddedString = text;
        for (int i = 0; i < n; i++) {
            paddedString += " ";
        }
        return paddedString;
    }

    private void printCursor() {
        System.out.print("\n> ");
    }

    private void printUnknownCommand() {
        System.out.println("Unknown command. Type help for info.");
    }

    private void quit() {
        System.out.println("Thank you for using kiosk v" + 0.6);
        this.running = false;
        this.input.close();
    }
}