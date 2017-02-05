package chess;

import org.junit.Test;
import junit.framework.TestCase;
import chess.pieces.Pawn;

public class BoardTest extends TestCase {

	@Test
	public void testCreate() {
		Board board = new Board();
		assertEquals(0, board.getNumberOfPawns());

		Pawn whitePawn = new Pawn();
		board.addPawn(whitePawn);;
		assertEquals(1, board.getNumberOfPawns());
		assertEquals(whitePawn, board.getPawn(0));

		Pawn blackPawn = new Pawn(Pawn.BLACK);
		board.addPawn(blackPawn);
		assertEquals(2, board.getNumberOfPawns());
		assertEquals(whitePawn, board.getPawn(0));
		assertEquals(blackPawn, board.getPawn(1));
	}

}
