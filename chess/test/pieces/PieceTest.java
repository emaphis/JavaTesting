package pieces;

import org.junit.Test;

import junit.framework.TestCase;
import pieces.Piece.*;

public class PieceTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		Piece.resetNumberPieces();
		//super.setUp();
	}

	@Test
	public void testCreate() {
		Piece pawn1 = Piece.createPawn(Color.BLACK);
		assertEquals(Color.BLACK, pawn1.getColor());
		assertTrue(pawn1.isBlack());
		assertFalse(pawn1.isWhite());

		Piece pawn2 = Piece.createPawn(Color.WHITE);
		assertEquals(Color.WHITE, pawn2.getColor());
		assertTrue(pawn2.isWhite());
		assertFalse(pawn2.isBlack());

		Piece none = Piece.noPiece();
		assertEquals(Color.NONE, none.getColor());
		assertTrue(none.isNone());
	}

	@Test
	public void testGetRepresentation() {
		Piece pawn1 = Piece.createPawn(Color.WHITE);
		assertEquals("p", pawn1.getRepresentation());

		Piece pawn2 = Piece.createPawn(Color.BLACK);
		assertEquals("P", pawn2.getRepresentation());

		Piece bishop = Piece.createBishop(Color.WHITE);
		assertEquals("b", bishop.getRepresentation());

		Piece none = Piece.noPiece();
		assertEquals(".", none.getRepresentation());
	}

	@Test
	public void testGetNumberOfPieces() {
		Piece.resetNumberPieces();
		assertEquals(0, Piece.getPieceCount(Color.WHITE));
		assertEquals(0, Piece.getPieceCount(Color.BLACK));

		Piece.createPawn(Color.WHITE);
		assertEquals(1, Piece.getPieceCount(Color.WHITE));
		assertEquals(0, Piece.getPieceCount(Color.BLACK));

		Piece.createPawn(Color.BLACK);
		assertEquals(1, Piece.getPieceCount(Color.WHITE));
		assertEquals(1, Piece.getPieceCount(Color.WHITE));

		Piece.createRook(Color.WHITE);
		assertEquals(2, Piece.getPieceCount(Color.WHITE));
		assertEquals(1, Piece.getPieceCount(Color.BLACK));

		Piece.noPiece();
		assertEquals(2, Piece.getPieceCount(Color.WHITE));
		assertEquals(1, Piece.getPieceCount(Color.BLACK));
	}
}
