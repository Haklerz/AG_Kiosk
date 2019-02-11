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
    private String title, author, publisher;
    private int pages, edition;

    /**
     * Constructor for the class Book.
     * @param title Title of the Book.
     * @param author Author of the Book.
     * @param pages Number of pages in the Book.
     * @param publisher Publisher of the Book.
     */
    public Book(String title, String author, String publisher, int pages, int edition) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.edition = edition;
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
     * Returns the publisher of the Book as a<code>String</code>.
     * @return Publisher of the Book.
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Returns the number of pages in the Book as an<code>int</code>.
     * @return Number of pages in the Book.
     */
    public int getPages() {
        return this.pages;
    }

    /**
     * Returns the edition of the book.
     * @return Edition of the Book.
     */
    public int getEdition() {
        return this.edition;
    }
}