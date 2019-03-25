package no.ntnu.ag.literature;

/**
 * Represents a periodical with a title, a publisher and a number of editions
 * per year.
 * 
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public abstract class Periodical extends Literature {
    private int editions;

    /**
     * Creates a periodical with a title, a publisher and a number of editions per
     * year.
     * 
     * @param title     the title
     * @param publisher the publisher
     * @param editions  the number of editions
     */
    public Periodical(String title, String publisher, int editions) {
        super(title, publisher);
        setEditions(editions);
    }

    /**
     * Returns the number of editions per year of the periodical as an<code>int</code>.
     * 
     * @return the editions per year
     */
    public int getEditions() {
        return editions;
    }

    /**
     * Sets the number of editions per year of the periodical as an<code>int</code>.
     * 
     * @param editions the editions per year to set
     */
    private void setEditions(int editions) {
        if (editions > 0) {
            this.editions = editions;
        } else {
            this.editions = 0;
        }
    }
}