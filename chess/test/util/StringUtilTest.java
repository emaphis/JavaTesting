package util;

import junit.framework.TestCase;
import org.junit.Test;

public class StringUtilTest extends TestCase {
	private String NEW_LINE = System.getProperty("line.separator");

	@Test
	public void testNEW_LINE() {
		assertEquals(NEW_LINE, StringUtil.NEW_LINE);
	}

	@Test
	public void testAddNL() {
		String testString = "This is a test string";
		assertEquals(testString + NEW_LINE, StringUtil.appendNewLine(testString));
	}

}
