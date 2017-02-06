package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterTest {

	@Test
	public void testIsWhitespace() {
		// https://www.tutorialspoint.com/java/java_characters.htm
		assertTrue(Character.isWhitespace('\n'));
		assertTrue(Character.isWhitespace('\t'));
		assertTrue(Character.isWhitespace(' '));
		assertTrue(Character.isWhitespace('\r'));
		assertTrue(Character.isWhitespace('\f'));

		assertFalse(Character.isWhitespace('a'));
		assertFalse(Character.isWhitespace('3'));
		assertFalse(Character.isWhitespace('&'));
		assertFalse(Character.isWhitespace('\\'));
	}

	@Test
	public void testIsIdentifier() {
		assertTrue(Character.isJavaIdentifierStart('a'));
		assertTrue(Character.isJavaIdentifierStart('_'));
		assertTrue(Character.isJavaIdentifierStart('$'));

		assertFalse(Character.isUnicodeIdentifierStart('2'));
		assertFalse(Character.isUnicodeIdentifierStart('&'));
		assertFalse(Character.isUnicodeIdentifierStart('#'));
		assertFalse(Character.isUnicodeIdentifierStart('{'));
		assertFalse(Character.isUnicodeIdentifierStart('@'));
		// and much more
	}
}
