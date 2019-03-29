package no.ntnu.ag.literature;

/**
 * Represents a newspaper with a title, a publisher and a number of editions per
 * year.
 * 
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public class Newspaper extends Periodical {
    /**
     * Creates a newspaper with a title, a publisher and a number of editions per
     * year.
     * 
     * @param title     the title
     * @param publisher the publisher
     * @param editions  the number of editions
     */
    public Newspaper(String title, String publisher, int editions) {
        super(title, publisher, editions);
    }
}