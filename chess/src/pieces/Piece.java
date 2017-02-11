package pieces;

/**
* A piece in a game of chess
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
	private static int numberOfPieces = 0;


	/**
	* Constructs a Piece with a given color
	*
	* @param color of the Piece
	*/
	public Piece(String color, String name) {
		this.color = color;
		this.name = name;
		numberOfPieces = numberOfPieces + 1;
	}

	/**
	* @return color of the Pawn
	*/
	String getColor() {
		return color;
	}

	public String getName() {
		if (color == Piece.WHITE)
			return name;
		else
			return name.toUpperCase();
	}

	// class interface
	public static void resetNumberPieces() {
		numberOfPieces = 0;
	}

	public static int getNumberPieces() {
		return numberOfPieces;
	}
}
