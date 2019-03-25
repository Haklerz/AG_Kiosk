
/**
 * Write a description of class Litteratur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Litteratur
{
    // instance variables - replace the example below with your own
    private String author;
    private String publisher;
    private int pages;
    private String title;

    /**
     * Constructor for objects of class Litteratur
     */
    public Litteratur(String author, String publisher, int pages, String title)
    {
        // initialise instance variables
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.title = title;
    }
    
    /**
     * returns the books author.
     * @return the author of the book.
     */
    public String getAuthor()
    {
        return this.author;
    }

    /**
     * returns the books publisher.
     * @return the publisher of the book.
     */
    public String getPublisher()
    {
        return this.publisher;
    }
    
    /**
     * returns the books title.
     * @return the title of the book.
     */
    public String getTitle()
    {
        return this.title; 
    }
    
    /**
     * returns the amout of pages in the book.
     * @return the amount of pages in the book.
     */
    public int getPages()
    {
        return this.pages;
    }
}
