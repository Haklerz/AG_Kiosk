package no.ntnu.ag.Literature;

/**
 * Represents a journal with a title, a publisher and a number of editions per
 * year.
 * 
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public class Journal extends Periodical {
    public String genre;

    /**
     * Creates a journal with a title, a publisher and a number of editions per
     * year.
     * 
     * @param title     the title
     * @param publisher the publisher
     * @param editions  the number of editions
     * @param genre     the genre
     */
    public Journal(String title, String publisher, int editions, String genre) {
        super(title, publisher, editions);
        this.setGenre(genre);
    }

    /**
     * Returns the genre of the journal.
     * 
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the journal.
     * 
     * @param genre the genre to set
     */
    private void setGenre(String genre) {
        if (genre.trim().length() > 0) {
            this.genre = genre;
        } else {
            this.genre = "noGenre";
        }
    }
}