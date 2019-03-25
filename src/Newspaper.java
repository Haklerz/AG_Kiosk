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
public class Newspaper extends Litteratur
{
    // instance variables - replace the example below with your own
    // private String author;
    // private String publisher;
    // private int pages;
    // private String title;
    private int issuesPerYear;

    /**
     * Constructor for objects of class Newspaper
     */
    public Newspaper(String author, String publisher, int pages, String title, int issues)
    {
        // this.author = author;
        // this.publisher = publisher;
        // this.pages = pages;
        // this.title = title;
        super(author, publisher, pages, title);
        this.issuesPerYear = issues; 
    }
    
    /**
     * returns the number of issues the newspaper has a year.
     * @return the number of issues.
     */
    public int getIssuesPerYear(){
        return this.issuesPerYear;
    }
    
    // /**
     // * returns the books author.
     // * @return the author of the book.
     // */
    // public String getAuthor()
    // {
        // return this.author;
    // }

    // /**
     // * returns the books publisher.
     // * @return the publisher of the book.
     // */
    // public String getPublisher()
    // {
        // return this.publisher;
    // }
    
    // /**
     // * returns the books title.
     // * @return the title of the book.
     // */
    // public String getTitle()
    // {
        // return this.title; 
    // }
    
    // /**
     // * returns the amout of pages in the book.
     // * @return the amount of pages in the book.
     // */
    // public int getPages()
    // {
        // return this.pages;
    // }
}
