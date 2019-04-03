

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BookSeriesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookSeriesTest
{
    BookSeries bookSeries1 = new BookSeries("LOTR", "A & U");
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
    public void setUp()
    {
        bookSeries1.fillWithLOTR();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        assertEquals(3, bookSeries1.numberOfBooks());
    }
}
