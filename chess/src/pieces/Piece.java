package pieces;

/**
* A piece in a game of chess
* Piece is a value object.
*
* @author emaphis
*/
public class Piece {
	public static final String WHITE = "white";
	public static final String BLACK = "black";

	// Piece names
	public static final String PAWN = "p";
	public static final String ROOK = "r";
	public static final String KNIGHT = "n";
	public static final String BISHOP = "b";
	public static final String QUEEN = "q";
	public static final String KING = "k";

	private final String color;
	private String name;
	private static int whiteNumber = 0;
	private static int blackNumber = 0;


	/**
	* Constructs a Piece with a given color
	*
	* @param color of the Piece
	*        name of Piece
	*/
	private Piece(String color, String name) {
		this.color = color;
		this.name = name;
	}

	/**
	* @return color of the Pawn
	*/
	String getColor() {
		return color;
	}

	/**
	 * Get one character string name of Piece.
	 * @return name
	 */
	public String getName() {
		if (color == Piece.WHITE)
			return name;
		else
			return name.toUpperCase();
	}

	public boolean isWhite() {
		return color == WHITE;
	}

	public boolean isBlack() {
		return color == BLACK;
	}

	// class interface
	public static Piece createPiece(String color, String name) {
		if (color == WHITE)
			whiteNumber++;
		else
			blackNumber++;

		return new Piece(color, name);
	}

	public static void resetNumberPieces() {
		whiteNumber = 0;
		blackNumber = 0;
	}

	public static int getNumber(String color) {
		if (color == WHITE)
			return whiteNumber;
		else
			return blackNumber;
	}
}
