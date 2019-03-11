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
 * 
 * @author Håkon "Haklerz" Lervik, Trym "MrRazuuus" Jørgensen, Peter
 *         "ComradePetah" H. Osnes
 * @version 0.1
 */
public class Book extends Literature {
    // private String title;
    // private String author;
    // private String publisher;
    private int pages;
    private int edition;

    /**
     * Creates a Book.
     * 
     * @param title     Title of the Book.
     * @param author    Author of the Book.
     * @param pages     Number of pages in the Book.
     * @param publisher Publisher of the Book.
     */
    public Book(String title, String author, String publisher, int pages, int edition) {
        super(title, author, publisher);
        this.setPages(pages);
        this.setEdition(edition);
    }

    /**
     * Sets the edition of the book.
     * 
     * @param edition edition of the book.
     */
    private void setEdition(int edition) {
        if (edition > 0) {
            this.edition = edition;
        } else
            throw new IllegalArgumentException();
    }

    /**
     * Sets the number of pages in the book.
     * 
     * @param pages number of pages in the book.
     * @throws IllegalArgumentException
     */
    private void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        } else
            throw new IllegalArgumentException();
    }

    /**
     * Returns the number of pages in the book as an<code>int</code>.
     * 
     * @return number of pages in the book
     */
    public int getPages() {
        return this.pages;
    }

    /**
     * Returns the edition of the book as an<code>int</code>.
     * 
     * @return edition of the book
     */
    public int getEdition() {
        return this.edition;
    }
}