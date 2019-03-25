package no.ntnu.ag.Literature;

/**
 * Represents a magazine with a title, a publisher, a number of editions per
 * year and a genre.
 * 
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public class Magazine extends Journal {
    /**
     * Creates a magazine with a title, a publisher, a number of editions per year
     * and a genre.
     * 
     * @param title     the title
     * @param publisher the publisher
     * @param editions  the number of editions
     * @param genre     the genre
     */
    public Magazine(String title, String publisher, int editions, String genre) {
        super(title, publisher, editions, genre);
    }
}