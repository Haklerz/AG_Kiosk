

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BookRegistryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookRegistryTest
{
    /**
     * Default constructor for test class BookRegistryTest
     */
    public BookRegistryTest()
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
    public void testSize()
    {
        BookRegistry bookRegi1 = new BookRegistry();
        bookRegi1.fillDummies();
        assertEquals(3, bookRegi1.numberOfBooks());
    }
}

