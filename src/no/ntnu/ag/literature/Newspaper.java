package no.ntnu.ag.literature;

import no.ntnu.ag.exceptions.IllegalNumEditionsException;
import no.ntnu.ag.exceptions.IllegalPublisherException;
import no.ntnu.ag.exceptions.IllegalTitleException;

/**
 * Represents a newspaper with a title, a publisher and a number of editions per
 * year.
 * @author Håkon "Haklerz" Lervik
 * @version 2019.3.25
 */
public class Newspaper extends Periodical {
    /**
     * Creates a newspaper with a title, a publisher and a number of editions per
     * year.
     * @param title     the title
     * @param publisher the publisher
     * @param editions  the number of editions
     */
    public Newspaper(String title, String publisher, int editions) throws IllegalTitleException,
            IllegalPublisherException, IllegalNumEditionsException {
        super(title, publisher, editions);
    }
}