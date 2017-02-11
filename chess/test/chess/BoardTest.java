package chess;

import org.junit.Test;

import junit.framework.TestCase;
import pieces.Piece;
import pieces.Piece.Color;

import static util.StringUtil.appendNewLine;

public class BoardTest extends TestCase {
	private Board board;

	@Override
	protected void setUp() throws Exception {
		board = new Board();
		//super.setUp();
	}

	@Test
	public void testCreate() {
		board.intialize();
		assertEquals(32, board.getPieceCount());
		assertEquals(16, Piece.getPieceCount(Piece.Color.WHITE));
		assertEquals(16, Piece.getPieceCount(Piece.Color.BLACK));

		verifyCreation(
			Piece.createPawn(Color.WHITE), Piece.createPawn(Color.BLACK),
			Piece.Type.PAWN, Piece.PAWN_REPRESENTATION);
		verifyCreation(
			Piece.createRook(Color.WHITE), Piece.createRook(Color.BLACK),
			Piece.Type.ROOK, Piece.ROOK_REPRESENTATION);
		verifyCreation(
			Piece.createKnight(Color.WHITE), Piece.createKnight(Color.BLACK),
			Piece.Type.KNIGHT, Piece.KNIGHT_REPRESENTATION);
		verifyCreation(
			Piece.createBishop(Color.WHITE), Piece.createBishop(Color.BLACK),
			Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATION);
		verifyCreation(
			Piece.createQueen(Color.WHITE), Piece.createQueen(Color.BLACK),
			Piece.Type.QUEEN, Piece.QUEEN_REPRESENTATION);
		verifyCreation(
			Piece.createKing(Color.WHITE), Piece.createKing(Color.BLACK),
			Piece.Type.KING, Piece.KING_REPRESENTATION);
		Piece blank = Piece.noPiece();
		assertEquals(".", blank.getRepresentation());
		assertEquals(Piece.Type.NO_PIECE, blank.getType());
	}

	private void verifyCreation(Piece whitePiece, Piece blackPiece,
			Piece.Type type, String representation) {
			assertTrue(whitePiece.isWhite());
			assertEquals(type, whitePiece.getType());
			assertEquals(representation, whitePiece.getRepresentation());
			assertTrue(blackPiece.isBlack());
			assertEquals(type, blackPiece.getType());
			assertEquals(representation.toUpperCase(), blackPiece.getRepresentation());
	}


	@Test
	public void testPrint() {
		board.intialize();
		System.out.println(board.print());

		assertEquals("pppppppp", board.getRankRepresentation(2));
		assertEquals("PPPPPPPP", board.getRankRepresentation(7));
		assertEquals("RNBQKBNR", board.getRankRepresentation(8));
		assertEquals("........", board.getRankRepresentation(3));

		String blankRank = appendNewLine("........");
		assertEquals(
				appendNewLine("RNBQKBNR") +
		    	appendNewLine("PPPPPPPP") +
		    	blankRank + blankRank + blankRank + blankRank +
		    	appendNewLine("pppppppp") +
		    	appendNewLine("rnbqkbnr"),
		    	board.print());
	}
}
