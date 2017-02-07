package chess.pieces;

import org.junit.Test;

import junit.framework.TestCase;

public class PieceTest extends TestCase {

	@Test
	public void testCreate() {
		Piece firstPawn = new Piece();
		assertEquals(Piece.WHITE, firstPawn.getColor());
		assertEquals('p', firstPawn.getRepresentation());

		Piece secondPawn = new Piece(Piece.BLACK, 'P');
		assertEquals(Piece.BLACK, secondPawn.getColor());
		assertEquals('P', secondPawn.getRepresentation());
	}


}
