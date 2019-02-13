public class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String publisher;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String author, String title, int pages, String publisher)
    {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.publisher = publisher;
    }

    // Add the methods here ...
    
    public String getAuthor()
    {
        return this.author;
    }

    public String getPublisher()
    {
        return this.publisher;
    }
    
    public String getTitle()
    {
        return this.title; 
    }
    
    public int getPages()
    {
        return this.pages;
    }
}