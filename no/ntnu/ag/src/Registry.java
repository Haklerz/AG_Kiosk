package no.ntnu.ag.src;

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
     * Creates a Registry.
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

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    /**
     * Finds books by title. Returns an ArrayList of
     * books who's title contains the title given.
     * @return ArrayList of found books.
     */
    public ArrayList<Book> findByTitle(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        String testTitle = title.toUpperCase();
        for (Book book : books) {
            String bookTitle = book.getTitle().toUpperCase();
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
        String testAuthor = author.toUpperCase();
        for (Book book : books) {
            String bookAuthor = book.getAuthor().toUpperCase();
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
        String testPublisher = publisher.toUpperCase();
        for (Book book : books) {
            String bookPublisher = book.getPublisher().toUpperCase();
            if (bookPublisher.contains(testPublisher)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}