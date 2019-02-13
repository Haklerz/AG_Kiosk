package no.ntnu.ag.src;

/**
 * Represents a Book with a title, author and number of pages.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Get the title of the Book.
 * <li>Get the author of the Book.
 * <li>Get the number of pages in the Book.
 * </ul>
 */
public class Book {
    private String title;
    private String author;
    private String publisher;
    private int pages;
    private int edition;

    /**
     * Creates a Book.
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
     * Returns the edition of the Book.
     * @return Edition of the Book.
     */
    public int getEdition() {
        return this.edition;
    }
}