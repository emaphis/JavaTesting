
package com.leroy.pragmatic1.ch01;

/**
 * Demo class
 * @author emaphis
 */
public class Largest {
    public static int largest(int[] list) {
        int index;
        int max = Integer.MIN_VALUE;
        if (list.length == 0) {
            throw new RuntimeException("Empyt list");
        }
        for (index = 0; index < list.length; index++) {
            if (list[index] > max) {
                max = list[index];
            }
        }
        return max;
    }
}
