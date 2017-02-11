package pieces;

/**
* A piece in a game of chess
*
* @author emaphis
*/
public class Piece {
	public static final String WHITE = "white";
	public static final String BLACK = "black";
	public static final String BLANK = "blank"; // the empty square.

	private final String color;
	private Character name;
	private static int numberOfPieces = 0;

	/**
	* Constructs a default white Piece
	*
	*/
	public Piece() {
		this.color = WHITE;
		this.name = 'p';
		numberOfPieces = numberOfPieces + 1;
	}

	/**
	* Constructs a Piece with a given color
	*
	* @param color of the Piece
	*/
	public Piece(String color, Character name) {
		this.color = color;
		this.name = name;

		if (color != BLANK)  // cheat and use 'if'
			numberOfPieces = numberOfPieces + 1;
	}

	/**
	* @return color of the Pawn
	*/
	String getColor() {
		return color;
	}

	public Character getName() {
		return name;
	}

	// class interface
	public static void resetNumberPieces() {
		numberOfPieces = 0;
	}

	public static int getNumberPieces() {
		return numberOfPieces;
	}
}
