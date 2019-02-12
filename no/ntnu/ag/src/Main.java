package no.ntnu.ag.src;

import no.ntnu.ag.src.Book;
import no.ntnu.ag.src.Registry;
import java.util.ArrayList;

/**
 * The Main class contains the main method for running the application.
 */
public class Main {
    public static void main(String[] args) {
        //Search
        Registry r = new Registry();
        r.addBook(new Book("Objects first with Java", "David J. Barnes, Michael Kölling", "Pearson", 630, 6));
        r.addBook(new Book("Algoritmer og Datastrukturer", "Bo Puggaard Hansen, Martin Neiiendam", "Gyldendal", 101, 1));
        r.addBook(new Book("Electrical Engineering", "Allan R. Hambley", "Pearson", 866, 7));

        ArrayList<Book> foundBooks = r.findByPublisher("pear");
        for (Book book : foundBooks) {
            System.out.println(book.getTitle());
        }
        System.out.println();

        //List
        ArrayList<Book> books = r.getBooks();
        for (Book book : books) {
            System.out.println("Title     : " + book.getTitle());
            System.out.println("Author    : " + book.getAuthor());
            System.out.println("Publisher : " + book.getPublisher());
            System.out.println("Pages     : " + book.getPages());

            String edition = "" + book.getEdition();
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