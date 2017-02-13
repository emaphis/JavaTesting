package chess;

import org.junit.Test;

import junit.framework.TestCase;
import java.util.*;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

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
		board.initialize();
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
		board.initialize();
		//System.out.println(board.print());

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

	@Test
	public void testGetNumberOfAPiece() {
		board.initialize();

		assertEquals(8, board.getNumberOAfPiece(Color.WHITE, Type.PAWN));
		assertEquals(2, board.getNumberOAfPiece(Color.BLACK, Type.BISHOP));
		assertEquals(1, board.getNumberOAfPiece(Color.WHITE, Type.KING));
	}

	@Test
	public void testCoordinateToIndex() {
		assertEquals(0, board.getRankIdx("a1"));
		assertEquals(0, board.getFileIdx("a1"));
		assertEquals(7, board.getRankIdx("c8"));
		assertEquals(2, board.getFileIdx("c8"));
		assertEquals(4, board.getRankIdx("e5"));
		assertEquals(4, board.getFileIdx("e5"));
	}
	@Test
	public void testGetAt() {
		board.initialize();
		assertEquals(32, board.getPieceCount());

		Piece blackRook = board.getAt("a8");
		assertEquals(Piece.ROOK_REPRESENTATION.toUpperCase(), blackRook.getRepresentation());

		Piece whiteKing = board.getAt("e1");
		assertEquals(Piece.KING_REPRESENTATION, whiteKing.getRepresentation());
	}

	@Test
	public void testSetAt() {
		board.clearBoard();
		assertEquals(0, board.getPieceCount());

		Piece blackRook = Piece.createRook(Color.BLACK);
		board.setAt(blackRook, "a8");
		assertEquals(blackRook, board.getAt("a8"));

		Piece whiteKing = Piece.createKing(Color.WHITE);
		board.setAt(whiteKing, "e1");;
		assertEquals(whiteKing, board.getAt("e1"));
	}

	@Test
	public void testGetStrength() {
		board.clearBoard();
		assertEquals(0.0, board.getStrength(Color.WHITE));

		// add one pawn - only piece on the board should return 1.0
		board.setAt(Piece.createPawn(Color.WHITE), "a2");
		assertEquals(1.0, board.getStrength(Color.WHITE)); // 0 + 1 : 1

		// add a piece - same file, but not a pawn - should return  1 + rook(5)
		board.setAt(Piece.createRook(Color.WHITE), "a1");
		assertEquals(6.0, board.getStrength(Color.WHITE)); // 1 + 5 : 6

		// add a black bishop - different color - increment black
		board.setAt(Piece.createBishop(Color.BLACK), "g8");
		assertEquals(6.0, board.getStrength(Color.WHITE)); // 6 + 0 : 6
		assertEquals(3.0, board.getStrength(Color.BLACK)); // 0 + 3 : 3

		// king souldn't add any points
		board.setAt(Piece.createKing(Color.WHITE), "e1");
		assertEquals(6.0, board.getStrength(Color.WHITE)); // 6 + 0 : 6

		// test same rank but different file - should return full pawn
		board.setAt(Piece.createPawn(Color.WHITE), "b2");
		assertEquals(7.0, board.getStrength(Color.WHITE)); // 6 + 1 : 7

		// add pawn to same file - should reduce 1st paw to 0.5 and add 0.5 for new pawn
		board.setAt(Piece.createPawn(Color.WHITE), "b4");
		assertEquals(7.0, board.getStrength(Color.WHITE)); // 6 + 0.5 + 0.5 : 6
	}

	@Test
	public void testGetPawnStrength() {
		// same file is same letter coordinate but different number
		// different rank is different number coordinate
		board.clearBoard();
		Piece whitePawn1 = Piece.createPawn(Color.WHITE);
		Piece whitePawn2 = Piece.createPawn(Color.WHITE);
		Piece blackPawn3 = Piece.createPawn(Color.BLACK);

		board.setAt(whitePawn1, "a2");
		board.setAt(whitePawn2, "a3");
		assertEquals(0.5, board.getPawnStrength(board.getRankIdx("a2"), board.getFileIdx("a2"), whitePawn1));
		assertEquals(0.5, board.getPawnStrength(board.getRankIdx("a3"), board.getFileIdx("a3"), whitePawn2));

		// different file is different letter coordinate
		// same rank is same number coordinate
		board.clearBoard();
		board.setAt(whitePawn1, "a2");
		board.setAt(whitePawn2, "b2");
		assertEquals(1.0, board.getPawnStrength(board.getRankIdx("a2"), board.getFileIdx("a2"), whitePawn1));
		assertEquals(1.0, board.getPawnStrength(board.getRankIdx("b2"), board.getFileIdx("b3"), whitePawn2));

		// same file but different color
		board.clearBoard();
		board.setAt(whitePawn1, "a2");
		board.setAt(blackPawn3, "a3");
		assertEquals(1.0, board.getPawnStrength(board.getRankIdx("a2"), board.getFileIdx("a2"), whitePawn1));
		assertEquals(1.0, board.getPawnStrength(board.getRankIdx("a3"), board.getFileIdx("a3"), blackPawn3));
	}

	@Test
	public void testStrengthList() {
		board.clearBoard();

		board.setAt(Piece.createPawn(Color.WHITE), "a2");   // 1.0
		board.setAt(Piece.createPawn(Color.WHITE), "b2");   // 0.5 same file passed pawn
		board.setAt(Piece.createPawn(Color.WHITE), "b4");   // 0.5 same file passed pawn
		board.setAt(Piece.createQueen(Color.WHITE), "e1");  // 9.0
		board.setAt(Piece.createBishop(Color.WHITE), "d1"); // 3.0
		assertEquals(14.0, board.getStrength(Color.WHITE));
		List<Piece> list = board.getStrengthList(Color.WHITE);
		assertEquals(9.0, list.get(0).getStrength());
		assertEquals(3.0, list.get(1).getStrength());
		assertEquals(1.0, list.get(2).getStrength());
		assertEquals(0.5, list.get(3).getStrength());
		assertEquals(0.5, list.get(4).getStrength());
	}
}
