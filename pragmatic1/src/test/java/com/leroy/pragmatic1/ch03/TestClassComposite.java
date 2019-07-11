
package com.leroy.pragmatic1.ch03;

import junit.framework.*;

/**
 *
 * @author emaphis
 */
public class TestClassComposite extends TestCase {

    public TestClassComposite(String method) {
        super(method);
    }

    static public Test suite() {
        TestSuite suite = new TestSuite();
        // Grab everything:
        suite.addTestSuite(TestClassOne.class);
        // Use the suite method:
        suite.addTest(TestClassTwo.suite());
        return suite;
    }

}
