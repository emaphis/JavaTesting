package chess.pieces;

import org.junit.Test;
//import static Piece.Color;
//import static Piece.Type;

import junit.framework.TestCase;

public class PieceTest extends TestCase {

	@Test
	public void testCreate() {
		Piece firstPawn =  Piece.createWhite(Piece.Type.PAWN);
		assertEquals(Piece.Color.WHITE, firstPawn.getColor());
		assertEquals("p", firstPawn.getRepresentation());
		assertEquals(Piece.Type.PAWN, firstPawn.getType());

		Piece secondPawn = Piece.createBlack(Piece.Type.PAWN);
		assertEquals(Piece.Color.BLACK, secondPawn.getColor());
		assertEquals("P", secondPawn.getRepresentation());
		assertEquals(Piece.Type.PAWN, secondPawn.getType());
	}

	@Test
	public void testColorFunctions() {
		Piece piece1 = Piece.createWhite(Piece.Type.PAWN);
		assertTrue(piece1.isWhite());
		assertFalse(piece1.isBlack());

		Piece piece2 = Piece.createBlack(Piece.Type.PAWN);
		assertTrue(piece2.isBlack());
		assertFalse(piece2.isWhite());
	}
}
