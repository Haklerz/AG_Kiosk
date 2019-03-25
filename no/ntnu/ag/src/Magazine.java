package no.ntnu.ag.src;

/**
 * Magazine
 */
public class Magazine extends Periodical {
    private String genre;

    public Magazine(String title, String publisher, int editions, String genre) {
        super(title, publisher, editions);
        this.setGenre(genre);
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
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