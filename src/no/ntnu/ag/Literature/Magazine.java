package no.ntnu.ag.literature;

/**
 * Represents a magazine with a title, a publisher, a number of editions per
 * year and a genre.
 * 
 * @version 2019.3.25
 * @author Håkon "Haklerz" Lervik
 */
public class Magazine extends Periodical {
    public String genre;

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
        super(title, publisher, editions);
        this.setGenre(genre);
    }

    /**
     * Returns the genre of the magazine.
     * 
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the magazine.
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