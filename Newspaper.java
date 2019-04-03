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
 * @version 2019.03.25
 */
public class Newspaper extends Periodical
{
    // instance variables - replace the example below with your own
    // private String author;
    // private String publisher;
    // private int pages;
    // private String title;
    // private int issuesPerYear;

    /**
     * Constructor for objects of class Newspaper
     */
    public Newspaper(String publisher, int pages, String title, int issues)
    {
        // this.author = author;
        // this.publisher = publisher;
        // this.pages = pages;
        // this.title = title;
        super(publisher, pages, title, issues);
    }
}
