package src.no.ntnu.ag;

/**
 * Represents a Book with a title and publisher, an author, a number of pages
 * and an edition.
 * 
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public class Book extends Literature {
    private String author;
    private String edition;

    /**
     * Creates a Book with a title and publisher, an author and an edition.
     * 
     * @param title     the title
     * @param publisher the publisher
     * @param author    the author
     * @param edition   the edition
     */
    public Book(String title, String publisher, String author, String edition) {
        super(title, publisher);
        this.setAuthor(author);
        this.setEdition(edition);
    }

    /**
     * Sets the author of the book.
     * 
     * @param author the author
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
     * @param edition the edition
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
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the edition of the book as an<code>int</code>.
     * 
     * @return the edition
     */
    public String getEdition() {
        return this.edition;
    }
}