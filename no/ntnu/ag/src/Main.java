package no.ntnu.ag.src;

import no.ntnu.ag.src.Book;
import no.ntnu.ag.src.Registry;
import java.util.ArrayList;

/**
 * The Main class contains the main method for running the application.
 */
public class Main {
    public static void main(String[] args) {
        Registry r = new Registry();
        r.addBook(new Book("Objects first with Java", "David J. Barnes, Michael Kölling", "Pearson", 630, 6));
        r.addBook(new Book("Algoritmer og Datastrukturer", "Bo Puggaard Hansen, Martin Neiiendam", "Gyldendal", 101, 1));
        r.addBook(new Book("Electrical Engineering", "Allan R. Hambley", "Pearson", 866, 7));
        r.addBook(new Book("", "", "", 0, 0));

        ArrayList<Book> books = r.findByPublisher("pear");
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }
}