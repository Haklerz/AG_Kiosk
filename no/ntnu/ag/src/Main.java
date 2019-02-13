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
        r.fillDummies();

        ArrayList<Book> foundBooks = r.find("publisher","pearson");
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