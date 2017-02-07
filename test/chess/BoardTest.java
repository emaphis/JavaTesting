package chess;

import org.junit.Test;
import junit.framework.TestCase;
import static chess.util.StringUtil.appendNewLine;

public class BoardTest extends TestCase {

	@Test
	public void testCreate() {
		Board board = new Board();
		assertEquals(16, board.getNumberOfPawns());

		assertEquals("........", board.getRankRepresentation(0));
		assertEquals("pppppppp", board.getRankRepresentation(6));
		assertEquals("PPPPPPPP", board.getRankRepresentation(1));

		assertEquals(appendNewLine("........") +
					appendNewLine("PPPPPPPP") +
					appendNewLine("........") +
					appendNewLine("........") +
					appendNewLine("........") +
					appendNewLine("........") +
					appendNewLine("pppppppp") +
					appendNewLine("........"),
		          board.printBoard());

		System.out.println(board.printBoard());
	}

}
