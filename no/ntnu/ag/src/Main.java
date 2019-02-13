package no.ntnu.ag.src;

import no.ntnu.ag.src.Book;
import no.ntnu.ag.src.BookRegistry;
import java.util.ArrayList;

/**
 * The Main class contains the main method for running the application.
 */
public class Main {
    public static void main(String[] args) {
        //Search
        BookRegistry r = new BookRegistry();
        r.addBook(new Book("Objects first with Java", "David J. Barnes, Michael Kölling", "Pearson", 630, 6));
        r.addBook(new Book("Algoritmer og Datastrukturer", "Bo Puggaard Hansen, Martin Neiiendam", "Gyldendal", 101, 1));
        r.addBook(new Book("Electrical Engineering", "Allan R. Hambley", "Pearson", 866, 7));

        ArrayList<Book> foundBooks = r.find("publisher","pear");
        for (Book Book : foundBooks) {
            System.out.println(Book.getTitle());
        }
        System.out.println();

        //List
        ArrayList<Book> Books = r.getBooks();
        for (Book Book : Books) {
            System.out.println("Title     : " + Book.getTitle());
            System.out.println("Author    : " + Book.getAuthor());
            System.out.println("Publisher : " + Book.getPublisher());
            System.out.println("Pages     : " + Book.getPages());

            String edition = "" + Book.getEdition();
            String lastDigit = edition.substring(edition.length()-1);

            if (lastDigit.equals("1"))      edition = edition + "st";
            else if (lastDigit.equals("2")) edition = edition + "nd";
            else if (lastDigit.equals("3")) edition = edition + "rd";
            else                            edition = edition + "th";

            System.out.println("Edition   : " + edition);
            System.out.println();
        }
    }
}