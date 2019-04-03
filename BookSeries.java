import java.util.ArrayList;
import java.util.Iterator;

/**
 * Write a description of class BookSeries here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BookSeries extends Litteratur
{
    private ArrayList<Book> bookSeries; 

    public BookSeries(String publisher, String title){
        super(publisher, title);
        bookSeries = new ArrayList<>();
    }

    /**
     * adds a new book to the bookseries
     * @param the new book to add
     */
    public void addBook(Book book){
        bookSeries.add(book);
    }

    /**
     * returns the iterator of the booklist
     * @return the iterator of the booklist
     */
    public Iterator<Book> getIterator(){
        return bookSeries.iterator();
    }

    public void fillWithLOTR(){
        this.addBook(new Book("J.R.R Tolkien", "Allen & Unwin", 479, "Lord of the Rings - The Fellowship of the Ring", "Fantasy"));
        this.addBook(new Book("J.R.R Tolkien", "Allen & Unwin", 415, "Lord of the Rings - The Two Towers", "Fantasy"));
        this.addBook(new Book("J.R.R Tolkien", "Allen & Unwin", 347, "Lord of the Rings - The Return of the King", "Fantasy"));
    }

    /**
     * returns the number of litteratur in the registry
     * @return number of litteratur in the registry
     */
    public int numberOfBooks(){
        return bookSeries.size();
    }
}
