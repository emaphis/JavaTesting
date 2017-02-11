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
		Piece pawn1 = new Piece(Piece.BLACK, 'P');
		assertEquals(Piece.BLACK, pawn1.getColor());

		Piece pawn2 = new Piece(Piece.WHITE, 'p');
		assertEquals(Piece.WHITE, pawn2.getColor());
	}

	@Test
	public void testDefaultPawn() {
		Piece pawn = new Piece();
		assertEquals(Piece.WHITE, pawn.getColor());
		assertEquals(new Character('p'), pawn.getName());

	}

	@Test
	public void testGetName() {
		Piece pawn1 = new Piece(Piece.WHITE, 'p');
		assertEquals(new Character('p'), pawn1.getName());

		Piece pawn2 = new Piece(Piece.BLACK, 'P');
		assertEquals(new Character('P'), pawn2.getName());

		Piece pawn3 = new Piece(Piece.BLANK, '.');
		assertEquals(new Character('.'),pawn3.getName()); // test my cheet.
	}

	@Test
	public void testGetNumberOfPawns() {
		Piece.resetNumberPieces();
		assertEquals(0, Piece.getNumberPieces());
		new Piece();
		assertEquals(1, Piece.getNumberPieces());
		new Piece();
		assertEquals(2, Piece.getNumberPieces());

		// null pawns shouldn't update pawn count
		new Piece(Piece.BLANK, '.');
		assertEquals(2, Piece.getNumberPieces());
	}
}
