

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LitteraturRegistry.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LitteraturRegistryTest
{
    LitteraturRegistry litRegi1 = new LitteraturRegistry();
    /**
     * Default constructor for test class BookRegistryTest
     */
    public LitteraturRegistryTest()
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
        litRegi1.fillDummies();
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
        assertEquals(6, litRegi1.numberOfLitteraturs());
    }
}


