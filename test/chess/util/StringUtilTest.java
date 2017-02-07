package chess.util;


import org.junit.Test;

import chess.util.StringUtil;
import junit.framework.TestCase;

public class StringUtilTest extends TestCase {

	@Test
	public void testNewLine() {
		assertEquals("\n", StringUtil.NEWLINE);  // system dependant?
	}

	// test use case
	@Test
	public void testAppend() {
		assertEquals("testline\n", StringUtil.appendNewLine("testline"));
	}
}
