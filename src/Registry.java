package src;

import java.util.ArrayList;

/**
 * Represents a collection of books.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Add a book to the registry.
 * <li>List the contents of the Registry.
 * <li>Search the Registry by title.
 * <li>Search the Registry by author.
 * <li>Search the Registry by publisher.
 * <li>Add an existing book to a series.
 * </ul>
 * @see Book
 */
public class Registry {
    private ArrayList<Book> books;

    /**
     * Constructor for the Registry class.
     */
    public Registry() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the Registry.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Finds books by title. Returns an ArrayList of
     * books who's title contains the title given.
     * @return ArrayList of found books.
     */
    public ArrayList<Book> findByTitle(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            String bookTitle = book.getTitle().toUpperCase();
            String testTitle = title.toUpperCase();
            if (bookTitle.contains(testTitle)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /**
     * Finds books by title. Returns an ArrayList of
     * books who's title contains the author given.
     * @return ArrayList of found books.
     */
    public ArrayList<Book> findByAuthor(String author) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            String bookAuthor = book.getAuthor().toUpperCase();
            String testAuthor = author.toUpperCase();
            if (bookAuthor.contains(testAuthor)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /**
     * Finds books by publisher. Returns an ArrayList of
     * books who's title contians the publisher given.
     * @return ArrayList of found books.
     */
    public ArrayList<Book> findByPublisher(String publisher) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            String bookPublisher = book.getPublisher().toUpperCase();
            String testPublisher = publisher.toUpperCase();
            if (bookPublisher.contains(testPublisher)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}