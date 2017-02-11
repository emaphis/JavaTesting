package pieces;

import org.junit.Test;

import junit.framework.TestCase;

public class PieceTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		Piece.resetNumberPieces();
		//super.setUp();
	}

	@Test
	public void testCreate() {
		Piece pawn1 = Piece.createPiece(Piece.BLACK, Piece.PAWN);
		assertEquals(Piece.BLACK, pawn1.getColor());
		assertTrue(pawn1.isBlack());
		assertFalse(pawn1.isWhite());

		Piece pawn2 = Piece.createPiece(Piece.WHITE, Piece.PAWN);
		assertEquals(Piece.WHITE, pawn2.getColor());
		assertTrue(pawn2.isWhite());
		assertFalse(pawn2.isBlack());
	}


	@Test
	public void testGetName() {
		Piece pawn1 = Piece.createPiece(Piece.WHITE, Piece.PAWN);
		assertEquals("p", pawn1.getName());

		Piece pawn2 = Piece.createPiece(Piece.BLACK, Piece.PAWN);
		assertEquals("P", pawn2.getName());

		Piece bishop = Piece.createPiece(Piece.WHITE, Piece.BISHOP);
		assertEquals("b", bishop.getName());
	}

	@Test
	public void testGetNumberOfPieces() {
		Piece.resetNumberPieces();
		assertEquals(0, Piece.getNumber(Piece.WHITE));
		assertEquals(0, Piece.getNumber(Piece.BLACK));

		Piece.createPiece(Piece.WHITE, Piece.PAWN);
		assertEquals(1, Piece.getNumber(Piece.WHITE));
		assertEquals(0, Piece.getNumber(Piece.BLACK));

		Piece.createPiece(Piece.BLACK, Piece.PAWN);
		assertEquals(1, Piece.getNumber(Piece.WHITE));
		assertEquals(1, Piece.getNumber(Piece.WHITE));

		Piece.createPiece(Piece.WHITE, Piece.ROOK);
		assertEquals(2, Piece.getNumber(Piece.WHITE));
		assertEquals(1, Piece.getNumber(Piece.BLACK));
	}
}
