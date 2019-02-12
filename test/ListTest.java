package test;

import src.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Registry reg = new src.Registry();
        reg.addBook(new src.Book("Objects first with Java™", "David J. Barnes, Michael Kölling", "Pearson", 630, 6));
        reg.addBook(new src.Book("Algoritmer og Datastrukturer", "Bo Puggaard Hansen, Martin Neiiendam", "Gyldendal", 101, 1));
        reg.addBook(new src.Book("Electrical Engineering", "Allan R. Hambley", "Pearson", 866, 7));

        System.out.println("Book title:");
        ArrayList<src.Book> books = reg.findByTitle(input.next());
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        input.close();
    }
}