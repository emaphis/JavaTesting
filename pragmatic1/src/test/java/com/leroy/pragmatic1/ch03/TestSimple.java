
package com.leroy.pragmatic1.ch03;

import junit.framework.*;

/**
 * Simple JUnit test example
 * @author emaphis
 */
public class TestSimple extends TestCase {

    public TestSimple(String name) {
        super(name);
    }

    public void testAdd() {
        assertEquals(2, 1+1);
        assertEquals(4, 2+2);
        assertEquals(-8, -12+4);
        assertEquals(7, 3+4);
    }

}
