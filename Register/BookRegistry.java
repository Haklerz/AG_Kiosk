import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a collection of Books.
 * <p>
 * With this class you can:
 * <ul>
 * <li>Add a Book to the BookRegistry.
 * <li>List the contents of the BookRegistry.
 * <li>Search the BookRegistry by title.
 * <li>Search the BookRegistry by author.
 * <li>Search the BookRegistry by publisher.
 * <li>Add an existing Book to a series.
 * </ul>
 * @see Book
 */
public class BookRegistry {
    private ArrayList<Book> books;

    /**
     * Creates a BookRegistry.
     */
    public BookRegistry() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a Book to the BookRegistry.
     */
    public void addBook(Book book) {
        this.books.add(book);
    }

    /**
     * Returns the ArrayList containing all the Books in the Registry.
     * @return ArrayList of all the Books.
     */
    public ArrayList<Book> getBooks(){
        return this.books;
    }
    
    /**
     * Returns an iterator of the arraylist cotaining all the books in the registry
     * @return iterator of the arraylist
     */
    public Iterator<Book> getIterator(){
        return this.books.iterator();
    }

    /**
     * Finds Books by a searchType. Returns an ArrayList of
     * Books that contains the searchText.
     * <p>
     * This method can search by:
     * <ul>
     * <li>Title.
     * <li>Author.
     * <li>Publisher.
     * </ul>
     * @param searchType What property to search by.
     * @param searchText Text to search for.
     * @return ArrayList of found Books.
     */
    public Iterator findBook(String searchType, String searchText) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book testBook : books) {
            String testText = "";
            if (searchType.toLowerCase().contains("title")) {
                testText = testBook.getTitle();
            }
            else if (searchType.toLowerCase().contains("author")) {
                testText = testBook.getAuthor();
            }
            else if (searchType.toLowerCase().contains("publisher")) {
                testText = testBook.getPublisher();
            }
            testText = testText.toLowerCase();
            if (testText.contains(searchText.toLowerCase())) {
                foundBooks.add(testBook);
            }
        }
        return foundBooks.iterator();
    }
    
    public void fillDummies() {
        this.addBook(new Book("David J. Barnes, Michael Kölling", "Objects first with Java", 630, "Pearson"));
        this.addBook(new Book("Bo Puggaard Hansen, Martin Neiiendam", "Algoritmer og Datastrukturer", 101, "Gyldendal"));
        this.addBook(new Book("Allan R. Hambley", "Electrical Engineering", 866, "Pearson"));
    }
}