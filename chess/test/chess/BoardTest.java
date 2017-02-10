package chess;

import org.junit.Test;

import junit.framework.TestCase;

public class BoardTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		//super.setUp();
	}

	@Test
	public void testCreate() {
		Board board = new Board();
		board.intialize();
		//Pawn.resetNumberPawns();
		assertEquals(16, board.getNumber());
		assertEquals("pppppppp", board.getRankRepresentation(2));
		assertEquals("PPPPPPPP", board.getRankRepresentation(7));

		// test my cheat
		assertEquals("........", board.getRankRepresentation(1));
	}


    private  String expectedBoard1 =
    		"........" + Board.NEW_LINE +
    		"PPPPPPPP" + Board.NEW_LINE +
    		"........" + Board.NEW_LINE +
    		"........" + Board.NEW_LINE +
    		"........" + Board.NEW_LINE +
    		"........" + Board.NEW_LINE +
    		"pppppppp" + Board.NEW_LINE +
    		"........" + Board.NEW_LINE;

	@Test
	public void testBoardRepresentation() {
		Board board = new Board();
		board.intialize();

		System.out.println(board.getBoardRepresentation());

		assertEquals(expectedBoard1, board.getBoardRepresentation());
	}
}
