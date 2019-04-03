package no.ntnu.ag.literature;

import no.ntnu.ag.exceptions.IllegalAuthorException;
import no.ntnu.ag.exceptions.IllegalEditionException;
import no.ntnu.ag.exceptions.IllegalPublisherException;
import no.ntnu.ag.exceptions.IllegalTitleException;

/**
 * Represents a Book with a title and publisher, an author, a number of pages
 * and an edition.
 * @author Håkon "Haklerz" Lervik
 * @version 2019.3.25
 */
public class Book extends Literature {
    private String author;
    private String edition;

    /**
     * Creates a Book with a title and publisher, an author and an edition.
     * @param title     the title
     * @param publisher the publisher
     * @param author    the author
     * @param edition   the edition
     */
    public Book(String title, String publisher, String author, String edition) throws IllegalTitleException,
            IllegalPublisherException, IllegalAuthorException, IllegalEditionException {
        super(title, publisher);
        this.setAuthor(author);
        this.setEdition(edition);
    }

    /**
     * Sets the author of the book.
     * @param author the author
     */
    private void setAuthor(String author) throws IllegalAuthorException {
        if (author == null) {
            throw new IllegalAuthorException("author must be non-null");
        }
        else if (author.trim().length() <= 0) {
            throw new IllegalAuthorException("author must be non-empty");
        }
        else {
            this.author = author;
        }
    }

    /**
     * Sets the edition of the book.
     * @param edition the edition
     */
    private void setEdition(String edition) throws IllegalEditionException {
        if (edition == null) {
            throw new IllegalEditionException("edition must be non-null");
        }
        else if (edition.trim().length() <= 0) {
            throw new IllegalEditionException("edition must be non-empty");
        }
        else {
            this.edition = edition;
        }
    }

    /**
     * Returns the author of the book as a<code>String</code>.
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the edition of the book as an<code>int</code>.
     * @return the edition
     */
    public String getEdition() {
        return this.edition;
    }
}