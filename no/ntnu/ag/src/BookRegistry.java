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
        books.add(book);
    }

    /**
     * Returns the ArrayList containing all the Books in the Registry.
     * @return ArrayList of all the Books.
     */
    public ArrayList<Book> getBooks() {
        return this.books;
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
}