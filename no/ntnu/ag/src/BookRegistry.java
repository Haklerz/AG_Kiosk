package no.ntnu.ag.src;

import java.util.ArrayList;
import java.util.Iterator;

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
 * @author Håkon "Haklerz" Lervik, Trym "MrRazuuus" Jørgensen, Peter "ComradePetah" H. Osnes
 * @version 0.1
 */
public class BookRegistry {
    private ArrayList<Book> books;

    /**
     * Creates a BookRegistry.
     */
    public BookRegistry() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a Book to the BookRegistry.
     */
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
        else {
            throw new IllegalArgumentException("Must be a valid book.");
        }
    }

    /**
     * Removes a Book from the BookRegistry if present.
     */
    public void removeBook(Book book) {
        books.remove(book);
    }

    /**
     * Returns the ArrayList containing all the Books in the Registry.
     * @return ArrayList of all the Books.
     */
    public Iterator<Book> getBookIterator() {
        return this.books.iterator();
    }

    /**
     * Finds Books by a searchType. Returns an ArrayList of
     * Books that contains the searchText.
     * <p>
     * This method can search by:
     * <ul>
     * <li>Title.
     * <li>Author.
     * <li>Publisher.
     * </ul>
     * @param searchType What property to search by.
     * @param searchText Text to search for.
     * @return ArrayList of found Books.
     */
    public ArrayList<Book> find(String searchType, String searchText) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book testBook : books) {
            String testText = "";
            if (searchType.toLowerCase().contains("title")) {
                testText = testBook.getTitle();
            }
            else if (searchType.toLowerCase().contains("author")) {
                testText = testBook.getAuthor();
            }
            else if (searchType.toLowerCase().contains("publisher")) {
                testText = testBook.getPublisher();
            }
            testText = testText.toLowerCase();
            if (testText.contains(searchText.toLowerCase())) {
                foundBooks.add(testBook);
            }
        }
        return foundBooks;
    }

    /**
     * no
     */
    

    /**
     * Fills the book registry with dummie books.
     */
    public void fillDummies() {
        this.addBook(new Book("Objects first with Java", "David J. Barnes, Michael Kölling", "Pearson", 630, 6));
        this.addBook(new Book("Algoritmer og Datastrukturer", "Bo Puggaard Hansen, Martin Neiiendam", "Gyldendal", 101, 1));
        this.addBook(new Book("Electrical Engineering", "Allan R. Hambley", "Pearson", 866, 7));
    }
}