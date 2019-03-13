package no.ntnu.ag.src;

/**
 * Represents a periodical with a genre, type and number of editions per year.
 * 
 * @version 13.03.2019
 * @author Håkon "Haklerz" Lervik
 */
public class Periodical extends Literature {
    private String genre; // Science, art, fashon
    private String type; // Magazine, newspaper, journal
    private int editions; // per year

    public Periodical(String title, String publisher, String genre, String type, int editions) {
        super(title, publisher);
        setGenre(genre);
        setType(type);
        setEditions(editions);
    }

    /**
     * Returns the genre og the periodical.
     * 
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre og the periodical.
     * 
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        if (genre.trim().length() > 0) {
            this.genre = genre;
        } else {
            this.genre = "noGenre";
        }
    }

    /**
     * Returns the type of the periodical.
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the periodical.
     * 
     * @param type the type to set
     */
    public void setType(String type) {
        if (type.trim().length() > 0) {
            this.type = type;
        } else {
            this.type = "noType";
        }
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