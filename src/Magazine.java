/**
 * Represents a Newspaper.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Make a newspaper.
 * <li>Get the author of the newspaper.
 * <li>Get the title of the newspaper.
 * <li>Get the publisher of the newspaper.
 * <li>Get the amout of pages in the newspaper.
 * <li>Get the number of issues the newspaper has a year.
 * </ul>
 * @author Trym Jorgensen
 * @version 1.0
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
     * Constructor for objects of class Newspaper
     */
    public Magazine(String publisher, int pages, String title, int issues, String genre)
    {
        // this.author = author;
        // this.publisher = publisher;
        // this.pages = pages;
        // this.title = title;
        super(publisher, pages, title, issues);
        this.genre = genre; 
    }
    
    public String getGenre(){
        return this.genre;
    }
}
