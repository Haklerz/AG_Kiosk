/**
 * Represents a magazine.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Make a magazine.
 * <li>Get the author of the magazine.
 * <li>Get the title of the magazine.
 * <li>Get the publisher of the magazine.
 * <li>Get the amout of pages in the magazine.
 * <li>Get the number of issues the magazine has a year.
 * </ul>
 * @author Trym Jorgensen
 * @version 2019.03.25
 */
public class Magazine extends Periodical
{
    // instance variables - replace the example below with your own
    // private String author;
    // private String publisher;
    // private int pages;
    // private String title;
    // private int issuesPerYear;
    private String genre;

    /**
     * Constructor for objects of class magazine
     */
    public Magazine(String publisher, int pages, String title, int issues, String genre)
    {
        // this.author = author;
        // this.publisher = publisher;
        // this.pages = pages;
        // this.title = title;
        super(publisher, pages, title, issues);
        this.setGenre(genre);
    }
    
    /**
     * Get the genre of the magazine
     * @return the genre of the magazine
     */
    public String getGenre(){
        return this.genre;
    }
    
    /**
     * set the genre of the magazine
     */
    private void setGenre(String genre){
        this.genre = genre;
    }
}
