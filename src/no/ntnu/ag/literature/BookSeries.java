package no.ntnu.ag.literature;

import no.ntnu.ag.LiteratureCollection;
import no.ntnu.ag.exceptions.IllegalPublisherException;
import no.ntnu.ag.exceptions.IllegalTitleException;

import java.util.Iterator;

/**
 * Represents a series of books with a title and a publisher.
 * @author Håkon "Haklerz" Lervik
 * @version 2019.3.25
 */
public class BookSeries extends Literature {
    private LiteratureCollection bookList;

    /**
     * Creates a series of books with a title and a publisher.
     * @param title     the title
     * @param publisher the publisher
     */
    public BookSeries(String title, String publisher) throws IllegalTitleException, IllegalPublisherException {
        super(title, publisher);
        bookList = new LiteratureCollection();
    }

    /**
     * Adds a book to the series.
     * @param book the book to add
     */
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book to add must be non-null");
        }
        else {
            bookList.addLiterature(book);
        }
    }

    /**
     * Removes a book from the series.
     * @param book the book to remove
     */
    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book to remove must be a non-null");
        }
        else {
            bookList.removeLiterature(book);
        }
    }

    /**
     * Returns an iterator over the series of books.
     * @return an iterator over the series
     */
    public Iterator<Literature> getLiteratureIterator() {
        return bookList.getLiteratureIterator();
    }
}