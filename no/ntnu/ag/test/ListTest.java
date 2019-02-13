package no.ntnu.ag.test;

import no.ntnu.ag.src.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BookRegistry reg = new BookRegistry();
        reg.addBook(new Book("Objects first with Java™", "David J. Barnes, Michael Kölling", "Pearson", 630, 6));
        reg.addBook(new Book("Algoritmer og Datastrukturer", "Bo Puggaard Hansen, Martin Neiiendam", "Gyldendal", 101, 1));
        reg.addBook(new Book("Electrical Engineering", "Allan R. Hambley", "Pearson", 866, 7));

        System.out.println("Book title:");
        ArrayList<Book> Books = reg.findByTitle(input.next());
        for (Book Book : Books) {
            System.out.println(Book.getTitle());
        }
        input.close();
    }
}