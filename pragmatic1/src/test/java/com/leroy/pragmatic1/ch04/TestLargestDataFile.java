
package com.leroy.pragmatic1.ch04;

import com.leroy.pragmatic1.ch01.Largest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import junit.framework.*;
import java.util.StringTokenizer;

/**
 *
 * @author emaphis
 */
public class TestLargestDataFile extends TestCase {

    public  TestLargestDataFile(String name) {
        super(name);
    }

    /* Run all the test in testdata.txt (does not test
     * exception case). We'll get an error if any of the
     * file I/O goes wrong.
     */
    public void testFromFile() throws Exception {
        String line;
        BufferedReader rdr = new BufferedReader(new FileReader("testdata.txt"));
        while ((line = rdr.readLine()) != null) {
            if (line.startsWith("#")) {  // Ignore comments
                continue;
            }
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) {
                continue;  // Blank line
            }
            // Get expected value
            String val = st.nextToken();
            int expected = Integer.parseInt(val);
            // Add the arguments to Largest
            ArrayList argument_list = new ArrayList();
            while (st.hasMoreElements()) {
                String tok = st.nextToken();
                argument_list.add(Integer.parseInt(tok));
            }
            // Transfer object list into native array
            int[] arguments = new int[argument_list.size()];
            for (int i = 0; i < argument_list.size(); i++) {
                arguments[i] = ((Integer)argument_list.get(i));
            }

            // Run the assert
            assertEquals(expected, Largest.largest(arguments));
        }
    }
}