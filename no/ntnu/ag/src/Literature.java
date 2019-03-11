package no.ntnu.ag.src;

/**
 * Represents a literature object with a title, an author and a publisher.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Get the title of the literature object.
 * <li>Get the author of the literature object.
 * <li>Get the publisher of the literature object.
 * </ul>
 * 
 * @author Håkon "Haklerz" Lervik
 * @version 11.03.2019
 */
public abstract class Literature {
    private String title;
    private String author;
    private String publisher;

    /**
     * Initializes a literature object with a title, an author and a publisher.
     * 
     * @param title     title of the literature object
     * @param author    author of the literature object
     * @param publisher pulisher of the literature object
     */
    public Literature(String title, String author, String publisher) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublisher(publisher);
    }

    /**
     * Sets the title of the literature object.
     * 
     * @param title title of the literature object
     * @throws IllegalArgumentException
     */
    private void setTitle(String title) {
        if (title.trim().length() > 0) {
            this.title = title;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Sets the author of the literature object.
     * 
     * @param author author of the literature object
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
     * Sets the publisher of the literature object.
     * 
     * @param publisher publisher of the literature object
     * @throws IllegalArgumentException
     */
    private void setPublisher(String publisher) {
        if (author.trim().length() > 0) {
            this.publisher = publisher;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the title of the literature object as a<code>String</code>.
     * 
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the author of the literature object as a<code>String</code>.
     * 
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the publisher of the literature object as a<code>String</code>.
     * 
     * @return the publisher
     */
    public String getPublisher() {
        return this.publisher;
    }
}