

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        Book book1 = new Book("jens", "yes", -70, "trym");
        assertEquals(true, (book1.getPages() > 0));
    }

    @Test
    public void testGetAuthor()
    {
        Book book1 = new Book("jens", "yes", -70, "trym");
        assertEquals("jens", book1.getAuthor());
    }
    
    @Test
    public void testGetTitle()
    {
        Book book1 = new Book("jens", "yes", -70, "trym");
        assertEquals("yes", book1.getTitle());
    }
    
    @Test
    public void testGetPublisher()
    {
        Book book1 = new Book("jens", "yes", -70, "trym");
        assertEquals("trym", book1.getPublisher());
    }
}



