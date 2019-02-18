package no.ntnu.ag.src;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Represents a Text-base User Interface.
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
        if (command.equals("help")) {
            System.out.println("help [command] Provides help info on commands.");
            System.out.println("new            Adds new book.");
            System.out.println("remove         Removes an existing book.");
            System.out.println("find [search]  Searches for a book by search category.");
            System.out.println("list           Lists the entire Registry.");
        }
        else if (command.equals("list")) {
            this.list();
        }
    }

    private void list() {
        ArrayList<Book> books = bookRegistry.getBooks();
        for (Book book : books) {
            System.out.println("Title     " + book.getTitle());
            System.out.println("Author    " + book.getAuthor());
            System.out.println("Publisher " + book.getPublisher());
            System.out.println("Pages     " + book.getPages());
            System.out.println("Edition   " + book.getEdition());
            System.out.println();
        }
    }

    public void shutdown() {
        this.input.close();
    }
}