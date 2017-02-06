package chess;

import org.junit.Test;
import junit.framework.TestCase;

public class BoardTest extends TestCase {

	@Test
	public void testCreate() {
		Board board = new Board();
		assertEquals(16, board.getNumberOfPawns());

		assertEquals("........", board.getRankRepresentation(0));
		assertEquals("pppppppp", board.getRankRepresentation(6));
		assertEquals("PPPPPPPP", board.getRankRepresentation(1));

		assertEquals("........\n" +
		             "PPPPPPPP\n" +
		             "........\n" +
		             "........\n" +
		             "........\n" +
		             "........\n" +
		             "pppppppp\n" +
		             "........\n",
		          board.printBoard());

		System.out.println(board.printBoard());
	}

}
