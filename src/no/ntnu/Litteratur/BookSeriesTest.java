package no.ntnu.Litteratur;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import no.ntnu.Exception.IllegalPagesException;
import no.ntnu.Exception.IllegalAuthorException;
import no.ntnu.Exception.IllegalPublisherException;

/**
 * The test class BookSeriesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookSeriesTest
{
    BookSeries bookSeries1;
    /**
     * Default constructor for test class BookSeriesTest
     */
    public BookSeriesTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        try{
        bookSeries1 = new BookSeries("LOTR", "A & U");
        bookSeries1.fillWithLOTR();
    }
        catch(IllegalPagesException ipe){
            System.out.println("Pages was invalid");
        }
        catch(IllegalAuthorException iae){
            System.out.println(iae);
        }
        catch(IllegalPublisherException ipue)
        {
            System.out.print(ipue);
        }
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
    public void testSize()
    {
        assertEquals(3, bookSeries1.numberOfBooks());
    }
}
