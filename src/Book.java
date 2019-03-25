/**
 * Represents a Book.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Make a book.
 * <li>Get the author of the book.
 * <li>Get the title of the book.
 * <li>Get the publisher of the book.
 * <li>Get the amout of pages in the book.
 * </ul>
 * @author Trym Jorgensen
 */
public class Book extends Litteratur
{
    // The fields.
    // private String author;
    // private String title;
    // private int pages;
    // private String publisher;
    private String genre;
    private String author;
    
    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String author, String publisher, int pages, String title, String genre)
    {
        super(publisher, pages, title);
        this.genre = genre;
        this.author = author;
        // this.author = author;
        // this.title = title;
        // this.pages = pages;
        // this.publisher = publisher;
    }
    
    /**
    * returns the books author
    * @return the author of the book
    */
    public String getGenre()
    {
        return this.genre;
    }
    
    /**
     * returns the books author
     * @return the author of the book
     */
    public String getAuthor()
    {
        return this.author;
    }

    // /**
     // * returns the books publisher
     // * @return the publisher of the book
     // */
    // public String getPublisher()
    // {
        // return this.publisher;
    // }
    
    // /**
     // * returns the books title
     // * @return the title of the book
     // */
    // public String getTitle()
    // {
        // return this.title; 
    // }
    
    // /**
     // * returns the amout of pages in the book
     // * @return the amount of pages in the book
     // */
    // public int getPages()
    // {
        // return this.pages;
    // }
}