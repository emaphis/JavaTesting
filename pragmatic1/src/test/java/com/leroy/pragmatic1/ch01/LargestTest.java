/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leroy.pragmatic1.ch01;

import junit.framework.TestCase;

/**
 *
 * @author emaphis
 */
public class LargestTest extends TestCase {

    public LargestTest(String testName) {
        super(testName);
    }

    /**
     * Test of largest method, of class Largest.
     */
    public void testSimple() {
        assertEquals(9, Largest.largest(new int[] {7,8,9}));
    }

    public void testOrder() {
        assertEquals(9, Largest.largest(new int[] {9, 8, 7}));
        assertEquals(9, Largest.largest(new int[] {7, 9, 8}));
        assertEquals(9, Largest.largest(new int[] {7, 8, 9}));
    }

    public void testDups() {
        assertEquals(9, Largest.largest(new int[] {9, 7, 9, 9}));
        assertEquals(9, Largest.largest(new int[] {9, 9, 9, 9}));
    }

    public void testOne() {
        assertEquals(1, Largest.largest(new int[] {1}));
    }

    public void testNegatives() {
        int[] negList = new int[] {-9, -8, -7};
        assertEquals(-7, Largest.largest(negList));
    }

    public void testEmpty() {
        try {
            Largest.largest(new int[] {});
            fail("Should have thrown and exception");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }
}
