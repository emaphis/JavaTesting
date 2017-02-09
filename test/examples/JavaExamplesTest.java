package examples;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class JavaExamplesTest {

	@Test
	public void testChar() {
		char capitalA = 'A';
		assertEquals(65, capitalA);
		assertEquals('\u0041', capitalA); // unicode
		assertEquals('\101', capitalA);  // octal
	}

	@Test
	public void testString() {
		assertEquals("abcd", "ab".concat("cd"));
		assertEquals("abcdef", "abc" + "def");
		assertEquals("123456", "12" + "3" + "456");
	}

	@Test
    public void testSortStringsInPlace() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        java.util.Collections.sort(list);
        assertEquals("Boyle", list.get(0));
        assertEquals("Camus", list.get(1));
        assertEquals("Heller", list.get(2));
        assertEquals("Kafka", list.get(3));
    }

	@Test
    public void testSortStringsInNewList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        ArrayList<String> sortedList = new ArrayList<String>(list);
        java.util.Collections.sort(sortedList);
        assertEquals("Boyle", sortedList.get(0));
        assertEquals("Camus", sortedList.get(1));
        assertEquals("Heller", sortedList.get(2));
        assertEquals("Kafka", sortedList.get(3));

        assertEquals("Heller", list.get(0));
        assertEquals("Kafka", list.get(1));
        assertEquals("Camus", list.get(2));
        assertEquals("Boyle", list.get(3));
    }

	@Test
    public void testStringCompareTo() {
        assertTrue("A".compareTo("B") < 0);
        assertEquals(0, "A".compareTo("A"));
        assertTrue("B".compareTo("A") > 0);
	}

	enum Score { fieldGoal, touchdown, extraPoint,
		        twoPointConversion, safety };


	@Test
	public void testSwitchResults() {
		int totalPoints = 0;
		Score score = Score.touchdown;

		switch (score) {
		case fieldGoal:
			totalPoints += 3;
			break;
		case touchdown:
			totalPoints += 6;
			break;
		case extraPoint:
			totalPoints += 1;
			break;
		case twoPointConversion:
		case safety:
			totalPoints += 2;
			break;
		}
		assertEquals(6, totalPoints);
	}
}
