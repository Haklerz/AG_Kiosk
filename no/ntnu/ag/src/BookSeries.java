package no.ntnu.ag.src;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a series of books.
 */
public class BookSeries extends Literature {
    private ArrayList<Book> bookList;

    public BookSeries(String title, String publisher) {
        super(title, publisher);
        bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    public Iterator<Book> getBookIterator() {
        return bookList.iterator();
    }
}