package no.ntnu.ag.literature;

import no.ntnu.ag.exceptions.IllegalPublisherException;
import no.ntnu.ag.exceptions.IllegalTitleException;

/**
 * Represents a literature object with a title and a publisher.
 * @author Håkon "Haklerz" Lervik
 * @version 2019.3.25
 */
public abstract class Literature {
    private String title;
    private String publisher;

    /**
     * Initializes a literature object with a title and a publisher.
     * @param title     the title
     * @param publisher the pulisher
     */
    public Literature(String title, String publisher) throws IllegalTitleException, IllegalPublisherException {
        this.setTitle(title);
        this.setPublisher(publisher);
    }

    /**
     * Sets the title of the literature.
     * @param title the title
     */
    private void setTitle(String title) throws IllegalTitleException {
        if (title == null) {
            throw new IllegalTitleException("the title must be non-null");
        }
        else if (title.trim().length() <= 0) {
            throw new IllegalTitleException("the title must be non-empty");
        }
        else {
            this.title = title;
        }
    }

    /**
     * Sets the publisher of the literature.
     * @param publisher the publisher
     */
    private void setPublisher(String publisher) throws IllegalPublisherException {
        if (publisher == null) {
            throw new IllegalPublisherException("publisher must be non-null");
        }
        else if (publisher.trim().length() <= 0) {
            throw new IllegalPublisherException("publisher must be non-empty");
        }
        else {
            this.publisher = publisher;
        }
    }

    /**
     * Returns the title of the literature as a<code>String</code>.
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the publisher of the literature as a<code>String</code>.
     * @return the publisher
     */
    public String getPublisher() {
        return this.publisher;
    }
}