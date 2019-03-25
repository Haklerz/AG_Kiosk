
/**
 * Write a description of class Litteratur here.
 *
 * @author Trym Jørgensen
 * @version 2019.03.25
 */
public class Litteratur
{
    // instance variables - replace the example below with your own
    private String publisher;
    private int pages;
    private String title;
    
    /**
     * Constructor for objects of class Litteratur
     */
    public Litteratur(String publisher, int pages, String title)
    {
        // initialise instance variables
        this.publisher = publisher;
        this.pages = pages;
        this.title = title;
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
