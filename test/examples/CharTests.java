package examples;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharTests {

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

}
