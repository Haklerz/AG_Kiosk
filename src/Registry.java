package src;
import java.util.ArrayList;

/**
 * Represents a collection of books.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Add a book to the registry.
 * </ul>
 * @see Book
 */
public class Registry {
    private ArrayList<Book> books;

    public Registry() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
}