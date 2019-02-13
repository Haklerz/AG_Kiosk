import java.util.*;

/**
 * 
 */
public class BookRegister
{
    private ArrayList<Book> bookList;

    /**
     * Constructor for objects of class PhoneBook
     */
    public BookRegister()
    {
        this.bookList = new ArrayList<Book>();
    }

    /**
     * 
     * @param book
     */
    public void addBook(Book book)
    {
        this.bookList.add(book);
    }

    /**
     * 
     * @param title
     * @return
     */
    public ArrayList<Book> findByTitle(String title){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for(Book book : bookList){
         String bookTitle = book.getTitle().toUpperCase();
         String testTitle = title.toUpperCase();
            if(bookTitle.contains(testTitle)){
            foundBooks.add(book);
            }        
        }
        return foundBooks;
    }

    public ArrayList<Book> findByPublisher(String publisher){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for(Book book : bookList){
         String bookPublisher = book.getPublisher().toUpperCase();
         String testPublisher = publisher.toUpperCase();
            if(bookPublisher.contains(testPublisher)){
            foundBooks.add(book);
            }        
        }
        return foundBooks;
    }

    public ArrayList<Book> findByAuthor(String author){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for(Book book : bookList){
         String bookAuthor = book.getAuthor().toUpperCase();
         String testAuthor = author.toUpperCase();
            if(bookAuthor.contains(testAuthor)){
            foundBooks.add(book);
            }        
        }
        return foundBooks;
    }
}