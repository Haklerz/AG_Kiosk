
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
    private String title;
    
    /**
     * Constructor for objects of class Litteratur
     */
    public Litteratur(String publisher, String title)
    {
        // initialise instance variables
        this.setPublisher(publisher);
        this.setTitle(title);
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
     * sets the publisher of the litteratur.
     */
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    
    /**
     * sets the title of the litteratur.
     */
    public void setTitle(String title){
        this.title = title;
    }
}
