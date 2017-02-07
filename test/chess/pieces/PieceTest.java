package chess.pieces;

import org.junit.Test;

import junit.framework.TestCase;

public class PieceTest extends TestCase {

	@Test
	public void testCreate() {
		Piece firstPawn =  Piece.create(Piece.WHITE, "p");
		assertEquals(Piece.WHITE, firstPawn.getColor());
		assertEquals("p", firstPawn.getRepresentation());

		Piece secondPawn = Piece.create(Piece.BLACK, "P");
		assertEquals(Piece.BLACK, secondPawn.getColor());
		assertEquals("P", secondPawn.getRepresentation());
	}

	@Test
	public void testColorFunctions() {
		Piece piece1 = Piece.create(Piece.WHITE, "p");
		assertTrue(piece1.isWhite());
		assertFalse(piece1.isBlack());

		Piece piece2 = Piece.create(Piece.BLACK, "P");
		assertTrue(piece2.isBlack());
		assertFalse(piece2.isWhite());
	}
}
