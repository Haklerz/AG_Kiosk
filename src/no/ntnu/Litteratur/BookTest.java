package no.ntnu.Litteratur;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import no.ntnu.Exception.IllegalPagesException;
import no.ntnu.Exception.IllegalAuthorException;
import no.ntnu.Exception.IllegalPublisherException;

/**
 * The test class BookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookTest
{
    /**
     * Default constructor for test class BookTest
     */
    public BookTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testPages()
    {
        try{
            Book book1 = new Book("jens", "yes", -70, "trym", "textbook");
            assertEquals(true, (book1.getPages() > 0));
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

    @Test
    public void testGetAuthor()
    {
        try{
            Book book1 = new Book("jens", "yes", -70, "trym", "textbook");
            assertEquals("jens", book1.getAuthor());
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

    @Test
    public void testGetTitle()
    {
        try{
            Book book1 = new Book("jens", "yes", -70, "trym", "textbook");
            assertEquals("trym", book1.getTitle());
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

    @Test
    public void testGetPublisher()
    {
        try{
            Book book1 = new Book("jens", "yes", -70, "trym", "textbook");
            assertEquals("yes", book1.getPublisher());
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
}

