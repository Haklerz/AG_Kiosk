package no.ntnu.ag.literature;

/**
 * Represents a literature object with a title and a publisher.
 * 
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public abstract class Literature {
    private String title;
    private String publisher;

    /**
     * Initializes a literature object with a title and a publisher.
     * 
     * @param title     the title
     * @param publisher the pulisher
     */
    public Literature(String title, String publisher) {
        this.setTitle(title);
        this.setPublisher(publisher);
    }

    /**
     * Sets the title of the literature.
     * 
     * @param title the title
     */
    private void setTitle(String title) {
        if (title.trim().length() > 0) {
            this.title = title;
        } else {
            this.title = "noTitle";
        }
    }

    /**
     * Sets the publisher of the literature.
     * 
     * @param publisher the publisher
     */
    private void setPublisher(String publisher) {
        if (publisher.trim().length() > 0) {
            this.publisher = publisher;
        } else {
            this.publisher = "noPublisher";
        }
    }

    /**
     * Returns the title of the literature as a<code>String</code>.
     * 
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the publisher of the literature as a<code>String</code>.
     * 
     * @return the publisher
     */
    public String getPublisher() {
        return this.publisher;
    }
}