package no.ntnu;

import java.util.ArrayList;
import java.util.Iterator;

import no.ntnu.Litteratur.*;
import no.ntnu.Exception.IllegalPagesException;
import no.ntnu.Exception.IllegalAuthorException;
import no.ntnu.Exception.IllegalPublisherException;

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
 * 
 * @author Trym Jørgensen
 * @version 2019.03.25
 */
public class LitteraturRegistry {
    private ArrayList<Litteratur> litteraturs;

    /**
     * Creates a BookRegistry.
     */
    public LitteraturRegistry() {
        this.litteraturs = new ArrayList<>();
    }

    /**
     * Adds a Litteratur to the LitteraturRegistry.
     */
    public void addLitteratur(Litteratur litteratur) {
        this.litteraturs.add(litteratur);
    }

    /**
     * Returns the ArrayList containing all the litteratur in the Registry.
     * @return ArrayList of all the litteratur.
     */
    public ArrayList<Litteratur> getLitteraturs(){
        return this.litteraturs;
    }

    /**
     * returns the iterator of the arraylist containing all the litteratur in the registry.
     * @return iterator of all the litteratur.
     */
    public Iterator<Litteratur> getIterator(){
        return this.litteraturs.iterator();
    }

    /**
     * Finds Litteartur by a searchType. Returns an ArrayList of
     * Litteratur that contains the searchText.
     * <p>
     * This method can search by:
     * <ul>
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
            else if (searchType.toLowerCase().contains("author")){
                if(testLitteratur instanceof Book){
                    Book testBook = (Book) testLitteratur;
                    testText = testBook.getAuthor();
                }
            }
            testText = testText.toLowerCase();
            if (testText.contains(searchText.toLowerCase())) {
                foundLitteraturs.add(testLitteratur);
            }
        }
        return foundLitteraturs.iterator();
    }

    /**
     * Fills the registry with litteratur.
     */
    public void fillDummies() {
        try{
            BookSeries books = new BookSeries("Allen & Unwin", "Lord of the Rings");
            books.fillWithLOTR();

            this.addLitteratur(books);
            this.addLitteratur(new Book("David J. Barnes, Michael Kölling", "Pearson", 630, "Objects first with Java", "textbook"));
            this.addLitteratur(new Book("Bo Puggaard Hansen, Martin Neiiendam", "Gyldendal", 101, "Algoritmer og Datastrukturer", "textbook"));
            this.addLitteratur(new Book("Allan R. Hambley", "Pearson", 866, "Electrical Engineering", "textbook"));
            this.addLitteratur(new Newspaper("VG", 30, "VG", 340));
            this.addLitteratur(new Magazine("KK", 38, "KK", 52, "Kvinneblad"));
        }
        catch(IllegalPagesException ipe){
            System.out.println("Pages was invalid");
        }
        catch(IllegalAuthorException iae){
            System.out.println(iae);
        }
        catch(IllegalPublisherException ipue){
            System.out.println("Publisher was invalid");
        }
    }

    /**
     * returns the number of litteratur in the registry
     * @return number of litteratur in the registry
     */
    public int numberOfLitteraturs(){
        return litteraturs.size();
    }
}