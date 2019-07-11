
package com.leroy.pragmatic1.ch03;

import junit.framework.*;

/**
 * Define a test suite
 * @author emaphis
 */
public class TestClassTwo extends TestCase {

    public TestClassTwo(String method) {
        super(method);
    }

    // This one takes a few hours....
    public void testLongRunner() {
        TSP tsp = new TSP();
        assertEquals(2300, tsp.shortestPath(50)); // top 50
    }

    public void testShortTest() {
        TSP tsp = new TSP();
        assertEquals(140, tsp.shortestPath(5)); // top 5
    }


    public void testAnotherShortTest() {
        TSP tsp = new TSP();  // Load with default cities
        assertEquals(586, tsp.shortestPath(10)); // top 10
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        // Only include short tests
        //suite.addTest(new TestClassTwo("testLongRunner"));
        suite.addTest(new TestClassTwo("testShortTest"));
        suite.addTest(new TestClassTwo("testAnotherShortTest"));
        return suite;
    }
}
