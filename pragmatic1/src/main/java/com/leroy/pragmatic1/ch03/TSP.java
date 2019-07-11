
package com.leroy.pragmatic1.ch03;

/**
 * Mock Class
 * @author emaphis
 */
public class TSP {
    public int shortestPath(int num) {
        int ret = 0;
        if (num == 50) {
            ret = 2300;
        } else if (num == 5) {
            ret = 140;
        } else if (num == 10) {
            ret = 586;
        }
        return ret;
    }
}
