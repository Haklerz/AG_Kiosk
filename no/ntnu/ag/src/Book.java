package no.ntnu.ag.src;

/**
 * Represents a Book with a title and publisher, an author, a number of pages and an
 * edition.
 * 
 * @version 11.03.2019
 * @author Håkon "Haklerz" Lervik
 */
public class Book extends Literature {
    private String author;
    private int pages;
    private int edition;

    /**
     * Creates a Book with a title and publisher, an author, a number of pages and an
     * edition.
     * 
     * @param title     title of the Book
     * @param publisher publisher of the Book
     * @param author    author of the Book
     * @param pages     the number of pages
     * @param edition   the edition of the book
     */
    public Book(String title, String publisher, String author, int pages, int edition) {
        super(title, publisher);
        this.setAuthor(author);
        this.setPages(pages);
        this.setEdition(edition);
    }

    /**
     * Sets the author of the book.
     * 
     * @param author the author of the book
     * @throws IllegalArgumentException
     */
    private void setAuthor(String author) {
        if (author.trim().length() > 0) {
            this.author = author;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Sets the edition of the book.
     * 
     * @param edition the edition of the book
     * @throws IllegalArgumentException
     */
    private void setEdition(int edition) {
        if (edition > 0) {
            this.edition = edition;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Sets the number of pages in the book.
     * 
     * @param pages the number of pages in the book
     * @throws IllegalArgumentException
     */
    private void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        } else {
            throw new IllegalArgumentException();
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
     * Returns the number of pages in the book as an<code>int</code>.
     * 
     * @return the number of pages in the book
     */
    public int getPages() {
        return this.pages;
    }

    /**
     * Returns the edition of the book as an<code>int</code>.
     * 
     * @return the edition of the book
     */
    public int getEdition() {
        return this.edition;
    }
}