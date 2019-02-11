package kiosk.test;

import src.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Registry reg = new Registry();
        reg.addBook(new Book("Objects first with Java™", "David J. Barnes, Michael Kölling", "Pearson", 630, 6));
        reg.addBook(new Book("Algoritmer og Datastrukturer", "Bo Puggaard Hansen, Martin Neiiendam", "Gyldendal", 101, 1));
        reg.addBook(new Book("Electrical Engineering", "Allan R. Hambley", "Pearson", 866, 7));

        System.out.println("Book title:");
        ArrayList<Book> books = reg.findByTitle(input.next());
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        input.close();
    }
}