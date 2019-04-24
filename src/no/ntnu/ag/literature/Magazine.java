package no.ntnu.ag.literature;

import no.ntnu.ag.exceptions.IllegalGenreException;
import no.ntnu.ag.exceptions.IllegalNumEditionsException;
import no.ntnu.ag.exceptions.IllegalPublisherException;
import no.ntnu.ag.exceptions.IllegalTitleException;

/**
 * Represents a magazine with a title, a publisher, a number of editions per
 * year and a genre.
 * @author Håkon "Haklerz" Lervik
 * @version 2019.3.25
 */
public class Magazine extends Periodical {
    private String genre;

    /**
     * Creates a magazine with a title, a publisher, a number of editions per year
     * and a genre.
     * @param title     the title
     * @param publisher the publisher
     * @param editions  the number of editions
     * @param genre     the genre
     */
    public Magazine(String title, String publisher, int editions, String genre) throws IllegalTitleException,
            IllegalPublisherException, IllegalNumEditionsException, IllegalGenreException {
        super(title, publisher, editions);
        this.setGenre(genre);
    }

    /**
     * Returns the genre of the magazine.
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the magazine.
     * @param genre the genre to set
     */
    private void setGenre(String genre) throws IllegalGenreException {
        if (genre == null) {
            throw new IllegalGenreException("genre must be non-null");
        }
        else if (genre.trim().length() <= 0) {
            throw new IllegalGenreException("genre must be non-empty");
        }
        else {
            this.genre = genre;
        }
    }
}