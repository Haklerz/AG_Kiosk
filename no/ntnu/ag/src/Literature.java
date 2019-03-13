package no.ntnu.ag.src;

/**
 * Represents a literature object with a title and a publisher.
 * 
 * @version 13.03.2019
 * @author Håkon "Haklerz" Lervik
 */
public abstract class Literature {
    private String title;
    private String publisher;

    /**
     * Initializes a literature object with a title and a publisher.
     * 
     * @param title     the title of the literature object
     * @param publisher the pulisher of the literature object
     */
    public Literature(String title, String publisher) {
        this.setTitle(title);
        this.setPublisher(publisher);
    }

    /**
     * Sets the title of the literature object.
     * 
     * @param title the title of the literature object
     */
    private void setTitle(String title) {
        if (title.trim().length() > 0) {
            this.title = title;
        } else {
            this.title = "noTitle";
        }
    }

    /**
     * Sets the publisher of the literature object.
     * 
     * @param publisher the publisher of the literature object
     */
    private void setPublisher(String publisher) {
        if (publisher.trim().length() > 0) {
            this.publisher = publisher;
        } else {
            this.publisher = "noPublisher";
        }
    }

    /**
     * Returns the title of the literature object as a<code>String</code>.
     * 
     * @return the title of the literature object
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the publisher of the literature object as a<code>String</code>.
     * 
     * @return the publisher of the literature object
     */
    public String getPublisher() {
        return this.publisher;
    }

	public String getDetails() {
		return null;
	}
}