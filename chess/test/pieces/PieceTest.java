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
		Piece pawn1 = new Piece(Piece.BLACK, Piece.PAWN);
		assertEquals(Piece.BLACK, pawn1.getColor());

		Piece pawn2 = new Piece(Piece.WHITE, Piece.PAWN);
		assertEquals(Piece.WHITE, pawn2.getColor());
	}


	@Test
	public void testGetName() {
		Piece pawn1 = new Piece(Piece.WHITE, Piece.PAWN);
		assertEquals("p", pawn1.getName());

		Piece pawn2 = new Piece(Piece.BLACK, Piece.PAWN);
		assertEquals("P", pawn2.getName());

		Piece bishop = new Piece(Piece.WHITE, Piece.BISHOP);
		assertEquals("b", bishop.getName());
	}

	@Test
	public void testGetNumberOfPieces() {
		Piece.resetNumberPieces();
		assertEquals(0, Piece.getNumberPieces());
		new Piece(Piece.WHITE, Piece.PAWN);
		assertEquals(1, Piece.getNumberPieces());
		new Piece(Piece.WHITE, Piece.PAWN);
		assertEquals(2, Piece.getNumberPieces());
		new Piece(Piece.WHITE, Piece.ROOK);
		assertEquals(3, Piece.getNumberPieces());
	}
}
