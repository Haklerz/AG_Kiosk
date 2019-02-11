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
     * 
     */
    public Registry() {
        this.books = new ArrayList<>();
    }

    /**
     * 
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Finds books by title.
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
}