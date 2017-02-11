package pieces;

/**
* A piece in a game of chess
* Piece is a value object.
*
* @author emaphis
*/
public class Piece {
	public enum Color { WHITE, BLACK, NONE };
	public enum Type { PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, NO_PIECE }

	// Piece representation:
	public static final String PAWN_REPRESENTATION = "p";
	public static final String ROOK_REPRESENTATION = "r";
	public static final String KNIGHT_REPRESENTATION = "n";
	public static final String BISHOP_REPRESENTATION = "b";
	public static final String QUEEN_REPRESENTATION = "q";
	public static final String KING_REPRESENTATION = "k";
	public static final String NO_PIECE_REPRESENTATION = ".";

	private final Color color;
	private final Type type;
	private static int whiteNumber = 0;
	private static int blackNumber = 0;


	/**
	* Constructs a Piece with a given color
	*
	* @param color of the Piece
	*        name of Piece
	*/
	private Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}

	/**
	* @return color of the Piece
	*/
	Color getColor() {
		return color;
	}

	/**
	 * Get one character string name of Piece.
	 * @return name
	 */
	public String getRepresentation() {
		String rep;
		if (type == Type.PAWN)
			rep = PAWN_REPRESENTATION;
		else if (type == Type.ROOK)
			rep = ROOK_REPRESENTATION;
		else if (type == Type.KNIGHT)
			rep = KNIGHT_REPRESENTATION;
		else if (type == Type.BISHOP)
			rep = BISHOP_REPRESENTATION;
		else if (type == Type.QUEEN)
			rep = QUEEN_REPRESENTATION;
		else if (type == Type.KING)
			rep = KING_REPRESENTATION;
		else
			return NO_PIECE_REPRESENTATION;

		if (color == Color.WHITE)
			return rep;
		else
			return rep.toUpperCase();
	}

	public Type getType() {
		return type;
	}

	public boolean isWhite() {
		return color == Color.WHITE;
	}

	public boolean isBlack() {
		return color == Color.BLACK;
	}

	public boolean isNone() {
		return type == Type.NO_PIECE;
	}

	// class interface
	public static Piece createPawn(Color color) {
		return createPiece(color, Type.PAWN);
	}

	public static Piece createRook(Color color)
	{
		return createPiece(color, Type.ROOK);
	}

	public static Piece createKnight(Color color) {
		return createPiece(color, Type.KNIGHT);
	}

	public static Piece createBishop(Color color) {
		return createPiece(color, Type.BISHOP);
	}

	public static Piece createQueen(Color color) {
		return createPiece(color, Type.QUEEN);
	}

	public static Piece createKing(Color color) {
		return createPiece(color, Type.KING);
	}

	public static Piece noPiece() {
		return createPiece(Color.NONE, Type.NO_PIECE);
	}

	private static Piece createPiece(Color color, Type type) {
		if (color == Color.WHITE)
			whiteNumber++;
		else if (color == Color.BLACK)
			blackNumber++;

		return new Piece(color, type);
	}

	public static void resetNumberPieces() {
		whiteNumber = 0;
		blackNumber = 0;
	}

	public static int getPieceCount(Color color) {
		if (color == Color.WHITE)
			return whiteNumber;
		else
			return blackNumber;
	}
}
