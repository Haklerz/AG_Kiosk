
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
        this.setPublisher(publisher);
        this.setPages(pages);
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
     * returns the amout of pages in the book.
     * @return the amount of pages in the book.
     */
    public int getPages()
    {
        return this.pages;
    }
    
    public void setPages(int pages){
        this.pages = pages;
        if(pages>0){
            this.pages = 1;
        }
    }
    
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
}
