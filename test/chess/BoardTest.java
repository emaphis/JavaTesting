package chess;

import org.junit.Test;
import junit.framework.TestCase;
import chess.pieces.Piece;
import chess.util.StringUtil;

public class BoardTest extends TestCase {
	private Board board;

	protected void setUp() {
		board = new Board();
	}

	@Test
	public void testCreate() {
		Piece.resetCount();
		board.initialize();
		assertEquals(16, Piece.getNumberOfWhite());
		assertEquals(16, Piece.getNumberOfBlack());
		assertEquals(32, board.getNumberOfPieces());

		assertEquals("........", board.getRankName(4));
		assertEquals("pppppppp", board.getRankName(6));
		assertEquals("PPPPPPPP", board.getRankName(1));

		System.out.println(board.printBoard());

		String blankRank = StringUtil.appendNewLine("........");
		assertEquals(
				StringUtil.appendNewLine("RNBQKBNR") +
				StringUtil.appendNewLine("PPPPPPPP") +
				blankRank + blankRank + blankRank + blankRank +
				StringUtil.appendNewLine("pppppppp") +
				StringUtil.appendNewLine("rnbqkbnr"),
		     board.printBoard());
	}

	@Test
	public void testGetNumberOfPiece() {
		Piece.resetCount();
		board.initialize();
		assertEquals(8, board.getNumberOfAPiece(Piece.Type.PAWN, Piece.Color.WHITE));
		assertEquals(2, board.getNumberOfAPiece(Piece.Type.ROOK, Piece.Color.BLACK));
		assertEquals(1, board.getNumberOfAPiece(Piece.Type.KING, Piece.Color.WHITE));;
	}

	@Test
	public void testGetAt() {
		assertEquals(7, board.invertIndex(1));
		assertEquals(5, board.invertIndex(3));
		assertEquals(4, board.invertIndex(4));
		assertEquals(3, board.invertIndex(5));
		assertEquals(0, board.invertIndex(8));

		board.initialize();
		Piece blackRook = board.getAt("a8");
		assertEquals(Piece.Color.BLACK, blackRook.getColor());
		assertEquals(Piece.Type.ROOK, blackRook.getType());

		Piece whiteKing = board.getAt("e1");
		assertEquals(Piece.Color.WHITE, whiteKing.getColor());
		assertEquals(Piece.Type.KING, whiteKing.getType());
		//board.getAt("e1");
	}

	@Test
	public void testSetAt() {
		board.initialize();
		Piece blackRook = Piece.createBlack(Piece.Type.ROOK);
		board.setAt(blackRook, "a6");
		assertEquals(blackRook, board.getAt("a6"));
	}

	@Test
	public void testAssesValues() {
		Board board = new Board();
		board.empty();
		assertEquals(0.0, board.assesStrength(Piece.Color.WHITE), .00001);

		board.setAt(Piece.createWhite(Piece.Type.PAWN), "a2");
		assertEquals(1.0, board.assesStrength(Piece.Color.WHITE), .00001);

		board.setAt(Piece.createWhite(Piece.Type.PAWN), "b2");
		assertEquals(2.0, board.assesStrength(Piece.Color.WHITE), .00001);

		// TODO:
		//board.setAt(Piece.createWhite(Piece.Type.PAWN), "b3");
		//assertEquals(2.0, board.assesStrength(Piece.Color.WHITE), .00001);

		board.setAt(Piece.createWhite(Piece.Type.QUEEN), "d1");
		assertEquals(11.0, board.assesStrength(Piece.Color.WHITE), .00001);

		board.setAt(Piece.createWhite(Piece.Type.KING), "e1");
		assertEquals(11.0, board.assesStrength(Piece.Color.WHITE), .00001);

		board.setAt(Piece.createBlack(Piece.Type.ROOK), "a8");
		assertEquals(11.0, board.assesStrength(Piece.Color.WHITE), .00001);

	//	System.out.println(board.printBoard());
	}
}
