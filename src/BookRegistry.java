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
    private ArrayList<Litteratur> litteraturs;

    /**
     * Creates a BookRegistry.
     */
    public BookRegistry() {
        this.litteraturs = new ArrayList<>();
    }

    /**
     * Adds a Book to the BookRegistry.
     */
    public void addLitteratur(Litteratur litteratur) {
        this.litteraturs.add(litteratur);
    }

    /**
     * Returns the ArrayList containing all the Books in the Registry.
     * @return ArrayList of all the Books.
     */
    public ArrayList<Litteratur> getLitteraturs(){
        return this.litteraturs;
    }
    
    /**
     * returns the iterator of the arraylist containing all the books in the registry.
     * @return iterator of all the books.
     */
    public Iterator<Litteratur> getIterator(){
        return this.litteraturs.iterator();
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
     * <li>Genre.
     * </ul>
     * @param searchType What property to search by.
     * @param searchText Text to search for.
     * @return ArrayList of found Books.
     */
    public Iterator findLitteratur(String searchType, String searchText) {
        ArrayList<Litteratur> foundLitteraturs = new ArrayList<>();
        for (Litteratur testLitteratur : litteraturs) {
            String testText = "";
            if (searchType.toLowerCase().contains("title")) {
                testText = testLitteratur.getTitle();
            }
            else if (searchType.toLowerCase().contains("publisher")) {
                testText = testLitteratur.getPublisher();
            }
            testText = testText.toLowerCase();
            if (testText.contains(searchText.toLowerCase())) {
                foundLitteraturs.add(testLitteratur);
            }
        }
        return foundLitteraturs.iterator();
    }
    
     /**
     * Fills the registry with books.
     */
    public void fillDummies() {
        this.addLitteratur(new Book("David J. Barnes, Michael Kölling", "Pearson", 630, "Objects first with Java", "textbook"));
        this.addLitteratur(new Book("Bo Puggaard Hansen, Martin Neiiendam", "Gyldendal", 101, "Algoritmer og Datastrukturer", "textbook"));
        this.addLitteratur(new Book("Allan R. Hambley", "Pearson", 866, "Electrical Engineering", "textbook"));
        this.addLitteratur(new Newspaper("VG", 30, "VG", 340));
    }
    
        
    /**
     * returns the number of books in the registry
     * @return number of books in the registry
     */
    public int numberOfLitteraturs(){
        return litteraturs.size();
    }
}