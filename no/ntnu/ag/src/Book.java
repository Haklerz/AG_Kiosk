package no.ntnu.ag.src;

/**
 * Represents a Book with a title and publisher, an author, a number of pages
 * and an edition.
 * 
 * @version 13.03.2019
 * @author Håkon "Haklerz" Lervik
 */
public class Book extends Literature {
    private String author;
    private String edition;

    /**
     * Creates a Book with a title and publisher, an author and an edition.
     * 
     * @param title     title of the Book
     * @param publisher publisher of the Book
     * @param author    author of the Book
     * @param edition   the edition of the book
     */
    public Book(String title, String publisher, String author, String edition) {
        super(title, publisher);
        this.setAuthor(author);
        this.setEdition(edition);
    }

    /**
     * Sets the author of the book.
     * 
     * @param author the author of the book
     */
    private void setAuthor(String author) {
        if (author.trim().length() > 0) {
            this.author = author;
        } else {
            this.author = "noAuthor";
        }
    }

    /**
     * Sets the edition of the book.
     * 
     * @param edition the edition of the book
     */
    private void setEdition(String edition) {
        if (edition.trim().length() > 0) {
            this.edition = edition;
        } else {
            this.edition = "noEdition";
        }
    }

    /**
     * Returns the author of the book as a<code>String</code>.
     * 
     * @return the author of the book
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the edition of the book as an<code>int</code>.
     * 
     * @return the edition of the book
     */
    public String getEdition() {
        return this.edition;
    }
}