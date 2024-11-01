package org.roaringbitmap;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.roaringbitmap.RoaringBitmap;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
         RoaringBitmap rr = RoaringBitmap.bitmapOf(1,2,3,1000);
        assertTrue( rr.contains(3) );
    }
}
