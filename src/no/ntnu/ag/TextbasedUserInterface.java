package no.ntnu.ag;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import no.ntnu.ag.exceptions.*;
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
 * @author Håkon "Haklerz" Lervik
 * @version 2019.3.27
 */
public class TextbasedUserInterface {
    private static final int INFO_MARGIN = 16;
    private static final int MAX_TRIES = 5;
    private LiteratureCollection registry;
    private Literature currentLiterature;
    private boolean running;
    private Scanner input;

    /**
     *
     */
    public TextbasedUserInterface() {
        this.registry = new LiteratureCollection();
        fillDummies(); // temp.
        this.setCurrentLiterature(null);
        this.input = new Scanner(System.in);
    }

    private void fillDummies() {
        try {
            registry.addLiterature(new Book("The Hunger Games", "Scholastic Press", "Suzanne Collins", "First " +
                    "Edition"));
            registry.addLiterature(new Book("To Kill a Mockingbird", "Modern Classics", "Harper Lee", "First Edition"));
            registry.addLiterature(new Book("Pride and Prejudice", "Modern Library", "Jane Austen", "First Edition"));
            registry.addLiterature(new Book("Twilight", "Little, Brown and Company", "Stephenie Meyer", "First " +
                    "Edition"));
            BookSeries hp = new BookSeries("Harry Potter", "Bloomsbury Publishing");
            hp.addBook(new Book("The Philosopher's Stone", "Bloomsbury Publishing", "J.K. Rowling", "1st Edition"));
            hp.addBook(new Book("The Chamber of Secrets", "Bloomsbury Publishing", "J.K. Rowling", "1st Edition"));
            hp.addBook(new Book("The Prisoner of Azkaban", "Bloomsbury Publishing", "J.K. Rowling", "1st Edition"));
            hp.addBook(new Book("The Goblet of Fire", "Bloomsbury Publishing", "J.K. Rowling", "1st Edition"));
            hp.addBook(new Book("The Order of the Phoenix", "Bloomsbury Publishing", "J.K. Rowling", "1st Edition"));
            hp.addBook(new Book("The Half-Blood Prince", "Bloomsbury Publishing", "J.K. Rowling", "1st Edition"));
            hp.addBook(new Book("The Deathly Hallows", "Bloomsbury Publishing", "J.K. Rowling", "1st Edition"));
            registry.addLiterature(hp);
            registry.addLiterature(new Book("The Chronicles of Narnia", "HarperCollins", "C.S. Lewis", "Reissue " +
                    "Edition"));
            registry.addLiterature(new Journal("Teknisk Ukeblad", "Teknisk Ukeblad Media", 11, "Technology"));
            registry.addLiterature(new Magazine("KK", "Aller Media", 49, "Health and Lifestyle"));
            registry.addLiterature(new Newspaper("Aftenposten", "Schibsted Norge", 52));
            registry.addLiterature(new Newspaper("Dagbladet", "Aller Media", 52));
        } catch (Exception e) {
        }
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
        if (literature != null) this.currentLiterature = literature;
    }

    /**
     *
     */
    public void run() {
        this.running = true;

        while (running) {
            printCursor(getCurrentLiterature());
            String userInput = input.nextLine();
            Instruction instruction = Instruction.parseInstruction(userInput);

            switch (instruction.getCommand()) {
                case HELP:
                    printHelp();
                    break;

                case NEW:
                    setCurrentLiterature(newLiterature(instruction.getArgument()));
                    break;

                case MOVE:
                    break;

                case FIND:
                    list(find(this.registry.getLiteratureIterator(), instruction.getArgument()));
                    break;

                case LIST:
                    list(this.registry.getLiteratureIterator());
                    break;

                case QUIT:
                    quit();
                    break;

                case UNKNOWN:
                    printUnknownCommand();
                    break;
            }
        }
    }

    private void printUnknownCommand() {
        System.out.println("Unknown command. For info type 'help'");
    }

    private void printQuitMessage() {
        System.out.println("Thank you for using AG Kiosk. GoodBye!");
    }

    private void printUnknownLiteratureType() {
        System.out.println("Unknown type of literature. For info type 'help new'");
    }

    private void printHelp() {
        String commandString = "Valid commands:";
        for (Command command : Command.values()) {
            if (command != Command.UNKNOWN) {
                commandString += "\n" + command.getCommandString();
            }
        }
        System.out.println(commandString);
    }

    private Literature newLiterature(String type) {
        Literature literature = null;
        int tries = MAX_TRIES;
        boolean sucess = false;
        while (!sucess && tries > 0) {
            try {
                if (tries == MAX_TRIES) {
                    System.out.println("Please enter " + type.toLowerCase() + " details.");
                }
                else {
                    System.out.println("\nYou have " + tries + ((tries == 1) ? " try" : " tries") + " left.");
                    System.out.println("Please try again.");
                }
                switch (type.toLowerCase()) {
                    case "book":
                        System.out.print("Book title: ");
                        String title = input.nextLine();
                        System.out.print("Publisher: ");
                        String publisher = input.nextLine();
                        System.out.print("Author: ");
                        String author = input.nextLine();
                        System.out.print("Edition: ");
                        String edition = input.nextLine();
                        Book newBook = new Book(title, publisher, author, edition);
                        this.registry.addLiterature(newBook);
                        System.out.println("\nNew book, " + newBook.getTitle() + ", was created.");
                        break;

                    case "journal":
                        break;

                    case "magazine":
                        break;

                    case "newspaper":
                        break;

                    case "series":
                        break;

                    default:
                        printUnknownLiteratureType();
                        break;
                }
                sucess = true;
            } catch (IllegalTitleException ite) {
                System.out.println("Title was invalid.");
            } catch (IllegalPublisherException ipe) {
                System.out.println("Publisher was invalid.");
            } catch (IllegalAuthorException iae) {
                System.out.println("Author was invalid.");
            } catch (IllegalEditionException ide) {
                System.out.println("Edition was invalid.");
            }
            /*
            catch (IllegalNumEditionsException ine) {

            }
            catch (IllegalFieldException ife) {

            }
            catch (IllegalGenreException ige) {

            }
            */
            tries--;
        }
        return literature;
    }

    private boolean askYesNo(String question) {
        boolean sure = false;
        boolean answerBool = false;
        while (!sure) {
            System.out.println(question + " yes/no");
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("yes") || answer.equals("y")) {
                answerBool = true;
                sure = true;
            }
            else if (answer.equals("no") || answer.equals("n")) {
                answerBool = false;
                sure = true;
            }
        }
        return answerBool;
    }

    private Iterator<Literature> find(Iterator<Literature> literatureIterator, String searchText) {
        ArrayList<Literature> foundLiterature = new ArrayList<>();
        while (literatureIterator.hasNext()) {
            Literature literature = literatureIterator.next();
            String details = literature.getTitle() + " " + literature.getPublisher();
            if (details.toLowerCase().contains(searchText.toLowerCase())) {
                foundLiterature.add(literature);
            }
            if (literature instanceof BookSeries) {
                BookSeries bookSeries = (BookSeries) literature;
                Iterator<Literature> bookIterator = find(bookSeries.getLiteratureIterator(), searchText);
                while (bookIterator.hasNext()) foundLiterature.add(bookIterator.next());
            }
        }
        return foundLiterature.iterator();
    }

    /**
     *
     */
    private void list(Iterator<Literature> literatureIterator) {
        if (!literatureIterator.hasNext()) System.out.println("-No literature-");
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
     */
    private void printLiteratureDetails(Literature literature) {
        if (literature instanceof Book) {
            Book book = (Book) literature;
            System.out.println(padString("Book title") + book.getTitle() + "\n" + padString("Publisher") + book.getPublisher() + "\n" + padString("Author") + book.getAuthor() + "\n" + padString("Edition") + book.getEdition());
        }
        else if (literature instanceof Journal) {
            Journal journal = (Journal) literature;
            System.out.println(padString("Journal title") + journal.getTitle() + "\n" + padString("Publisher") + journal.getPublisher() + "\n" + padString("Field") + journal.getField() + "\n" + padString("Editions/year") + journal.getEditions());
        }
        else if (literature instanceof Newspaper) {
            Newspaper newspaper = (Newspaper) literature;
            System.out.println(padString("Newspaper title") + newspaper.getTitle() + "\n" + padString("Publisher") + newspaper.getPublisher() + "\n" + padString("Editions/year") + newspaper.getEditions());
        }
        else if (literature instanceof Magazine) {
            Magazine magazine = (Magazine) literature;
            System.out.println(padString("Magazine title") + magazine.getTitle() + "\n" + padString("Publisher") + magazine.getPublisher() + "\n" + padString("Genre") + magazine.getGenre() + "\n" + padString("Editions/year") + magazine.getEditions());
        }
        else if (literature instanceof BookSeries) {
            BookSeries bookSeries = (BookSeries) literature;
            System.out.println(padString("Series title") + bookSeries.getTitle() + "\n" + padString("Published by") + bookSeries.getPublisher());
            Iterator<Literature> bookIterator = bookSeries.getLiteratureIterator();
            int number = 0;
            while (bookIterator.hasNext()) {
                Book book = (Book) bookIterator.next();
                System.out.println(padString(++number + ". book") + book.getTitle());
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
    private void printCursor(Literature literature) {
        if (literature != null) {
            System.out.print("\n" + literature.getTitle() + "> ");
        }
        else {
            System.out.print("\n>");
        }
    }

    /**
     *
     */
    private void quit() {
        printQuitMessage();
        this.running = false;
        this.input.close();
    }
}