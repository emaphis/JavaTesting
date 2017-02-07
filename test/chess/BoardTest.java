package chess;

import org.junit.Test;
import junit.framework.TestCase;
import chess.util.StringUtil;

public class BoardTest extends TestCase {
	private Board board;

	protected void setUp() {
		board = new Board();
	}

	@Test
	public void testCreate() {
		board.initialize();
		assertEquals(16, board.getNumberOfPieces());

		assertEquals("........", board.getRankName(4));
		assertEquals("pppppppp", board.getRankName(6));
		assertEquals("PPPPPPPP", board.getRankName(1));

		System.out.println(board.printBoard());

		String blankRank = StringUtil.appendNewLine("........");
		assertEquals(
				StringUtil.appendNewLine("RNBQKBNR") +
				StringUtil.appendNewLine("PPPPPPPP") +
				blankRank + blankRank + blankRank + blankRank +
				StringUtil.appendNewLine("pppppppp") +
				StringUtil.appendNewLine("rnbqkbnr"),
		     board.printBoard());
	}

}
