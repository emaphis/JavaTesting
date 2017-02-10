package chess;

import org.junit.Test;

import junit.framework.TestCase;
import pieces.Pawn;

public class BoardTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		//super.setUp();
	}

	@Test
	public void testCreate() {
		Board board = new Board();
		assertEquals(0, board.getNumber());
	}

	@Test
	public void testAddPawn(){
		Board board = new Board();

		board.addPawn(new Pawn());
		assertEquals(1, board.getNumber());

		board.addPawn(new Pawn(Pawn.BLACK));
		assertEquals(2, board.getNumber());
	}

}
