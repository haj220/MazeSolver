package cs2114.mazesolver;

import student.TestCase;

/**
 * @author parkerjiang
 * @version 2018.04.07
 *
 */
public class LocationTest extends TestCase {
    private Location a;

    /**
     * a test class
     */
    public void setUp() {
        a = new Location(0, 0);
    }

    /**
     * a test class
     */
    public void testSet() {
        assertEquals(0, a.x());
        assertEquals(0, a.y());
    }

    /**
     * a test class
     */
    public void testDirectionm() {

        assertEquals(-1, (a.north()).y());
        assertEquals(1, (a.south()).y());
        assertEquals(-1, (a.west()).x());
        assertEquals(1, (a.east()).x());
    }

    /**
     * a test class
     */
    public void testTostring() {
        Location b = new Location(0, 0);
        Location c = new Location(1, 0);

        assertEquals("(0, 0)", a.toString());
        assertFalse(a.equals(c));
        assertTrue(a.equals(b));
        assertFalse(a == (null));

    }

}
