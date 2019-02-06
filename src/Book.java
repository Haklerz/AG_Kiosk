package src;

/**
 * Represents a book with a title, author and number of pages.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Get the title of the book.
 * <li>Get the author of the book.
 * <li>Get the number of pages in the book.
 * </ul>
 */
public class Book {
    private String title, author;
    private int pages;

    /**
     * Constructor for the class Book.
     * @param title Title of the Book.
     * @param author Author of the Book.
     * @param pages Number of pages in the Book.
     */
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    /**
     * Returns the title of the Book as a<code>String</code>.
     * @return Title of the Book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the author of the Book as a<code>String</code>.
     * @return Author of the Book.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the number of pages in the Book as an<code>int</code>.
     * @return Number of pages in the Book.
     */
    public int getPages() {
        return this.pages;
    }
}