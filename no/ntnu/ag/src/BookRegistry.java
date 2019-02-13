package no.ntnu.ag.src;

import java.util.ArrayList;

/**
 * Represents a collection of Books.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Add a Book to the BookRegistry.
 * <li>List the contents of the BookRegistry.
 * <li>Search the BookRegistry by title.
 * <li>Search the BookRegistry by author.
 * <li>Search the BookRegistry by publisher.
 * <li>Add an existing Book to a series.
 * </ul>
 * @see Book
 */
public class BookRegistry {
    private ArrayList<Book> Books;

    /**
     * Creates a BookRegistry.
     */
    public BookRegistry() {
        this.Books = new ArrayList<>();
    }

    /**
     * Adds a Book to the BookRegistry.
     */
    public void addBook(Book Book) {
        Books.add(Book);
    }

    public ArrayList<Book> getBooks() {
        return this.Books;
    }

    /**
     * Finds Books by title. Returns an ArrayList of
     * Books who's title contains the title given.
     * @return ArrayList of found Books.
     */
    public ArrayList<Book> findByTitle(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        String testTitle = title.toUpperCase();
        for (Book Book : Books) {
            String BookTitle = Book.getTitle().toUpperCase();
            if (BookTitle.contains(testTitle)) {
                foundBooks.add(Book);
            }
        }
        return foundBooks;
    }

    /**
     * Finds Books by title. Returns an ArrayList of
     * Books who's title contains the author given.
     * @return ArrayList of found Books.
     */
    public ArrayList<Book> findByAuthor(String author) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        String testAuthor = author.toUpperCase();
        for (Book Book : Books) {
            String BookAuthor = Book.getAuthor().toUpperCase();
            if (BookAuthor.contains(testAuthor)) {
                foundBooks.add(Book);
            }
        }
        return foundBooks;
    }

    /**
     * Finds Books by publisher. Returns an ArrayList of
     * Books who's title contians the publisher given.
     * @return ArrayList of found Books.
     */
    public ArrayList<Book> findByPublisher(String publisher) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        String testPublisher = publisher.toUpperCase();
        for (Book Book : Books) {
            String BookPublisher = Book.getPublisher().toUpperCase();
            if (BookPublisher.contains(testPublisher)) {
                foundBooks.add(Book);
            }
        }
        return foundBooks;
    }
}