package no.ntnu.ag.src;

/**
 * Represents a journal with a title, a publisher and a number of editions per
 * year.
 * 
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public class Journal extends Periodical {
    /**
     * Creates a journal with a title, a publisher and a number of editions per
     * year.
     * 
     * @param title     the title
     * @param publisher the publisher
     * @param editions  the number of editions
     */
    public Journal(String title, String publisher, int editions) {
        super(title, publisher, editions);
    }
}