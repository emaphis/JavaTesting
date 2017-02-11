package chess;

import org.junit.Test;

import junit.framework.TestCase;

import static util.StringUtil.addNL;

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


    private  String expectedBoard() {
    	StringBuilder builder = new StringBuilder();
    	builder.append(addNL("........"));
    	builder.append(addNL("PPPPPPPP"));
    	builder.append(addNL("........"));
    	builder.append(addNL("........"));
    	builder.append(addNL("........"));
    	builder.append(addNL("........"));
    	builder.append(addNL("pppppppp"));
    	builder.append(addNL("........"));
    	return builder.toString();
    }

	@Test
	public void testBoardRepresentation() {
		Board board = new Board();
		board.intialize();

		System.out.println(board.getBoardRepresentation());

		assertEquals(expectedBoard(), board.getBoardRepresentation());
	}
}
