package no.ntnu.ag.src;

/**
 * Represents a periodical with a number of editions per year.
 * 
 * @version 13.03.2019
 * @author Håkon "Haklerz" Lervik
 */
public abstract class Periodical extends Literature {
    private int editions; // per year

    public Periodical(String title, String publisher, int editions) {
        super(title, publisher);
        setEditions(editions);
    }

    /**
     * Returns the number of editions per year of the periodical.
     * 
     * @return the editions per year
     */
    public int getEditions() {
        return editions;
    }

    /**
     * Sets the number of editions per year of the periodical.
     * 
     * @param editions the editions per year to set
     */
    public void setEditions(int editions) {
        if (editions > 0) {
            this.editions = editions;
        } else {
            this.editions = 0;
        }
    }
}