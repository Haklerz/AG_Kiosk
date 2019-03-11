package no.ntnu.ag.src;

/**
 * Represents a peice of literature with a title, author and publisher.
 * 
 * @author Håkon "Haklerz" Lervik
 * @version 11.03.2019
 */
public abstract class Literature {
    private String title;
    private String author;
    private String publisher;

    /**
     * Initializes a literature object.
     * 
     * @param title     title of the peice of literature
     * @param author    author of the peice of literature
     * @param publisher pulisher of the peice of literature
     */
    public Literature(String title, String author, String publisher) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublisher(publisher);
    }

    /**
     * Sets the title of the peice of literature.
     * 
     * @param title title of the peice of literature
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
     * Sets the author of the peice of literature.
     * 
     * @param author author of the peice of literature
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
     * Sets the publisher of the peice of literature.
     * 
     * @param publisher publisher of the peice of literature
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
     * Returns the title of the peice of literature as a<code>String</code>.
     * 
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the author of the peice of literature as a<code>String</code>.
     * 
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the publisher of the peice of literature as a<code>String</code>.
     * 
     * @return the publisher
     */
    public String getPublisher() {
        return this.publisher;
    }
}