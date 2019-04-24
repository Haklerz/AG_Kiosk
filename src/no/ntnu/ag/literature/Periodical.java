package no.ntnu.ag.literature;

import no.ntnu.ag.exceptions.IllegalNumEditionsException;
import no.ntnu.ag.exceptions.IllegalPublisherException;
import no.ntnu.ag.exceptions.IllegalTitleException;

/**
 * Represents a periodical with a title, a publisher and a number of editions
 * per year.
 * @author Håkon "Haklerz" Lervik
 * @version 2019.3.25
 */
public abstract class Periodical extends Literature {
    private int editions;

    /**
     * Creates a periodical with a title, a publisher and a number of editions per
     * year.
     * @param title     the title
     * @param publisher the publisher
     * @param editions  the number of editions
     */
    public Periodical(String title, String publisher, int editions) throws IllegalTitleException,
            IllegalPublisherException, IllegalNumEditionsException {
        super(title, publisher);
        setEditions(editions);
    }

    /**
     * Returns the number of editions per year of the periodical as an<code>int</code>.
     * @return the editions per year
     */
    public int getEditions() {
        return editions;
    }

    /**
     * Sets the number of editions per year of the periodical as an<code>int</code>.
     * @param editions the editions per year to set
     */
    private void setEditions(int editions) throws IllegalNumEditionsException {
        if (editions <= 0) {
            throw new IllegalNumEditionsException("editions must be greater than 0");
        }
        else {
            this.editions = editions;
        }
    }
}