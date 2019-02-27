package no.ntnu.ag.src;

import no.ntnu.ag.src.BookRegistry;
import no.ntnu.ag.src.Book;
import java.util.Scanner;

/**
 * SearchTest
 */
public class SearchTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BookRegistry br = new BookRegistry();
        br.fillDummies();

        for (int i = 0; i < 10; i++) {
            System.out.print("Find book: ");
            Book book = br.findBook(input.nextLine());
            if (!book.equals(null)) {
                System.out.println(book.getTitle());
            }
            else {
                System.out.println("Could not find book.");
            }
        }

        input.close();
    }
}