package pieces;

/**
* A pawn in a game of chess
*
* @author emaphis
*/
public class Pawn {
	public static final String WHITE = "white";
	public static final String BLACK = "black";
	public static final String BLANK = "blank"; // the empty square.

	private final String color;
	private Character name;
	private static int numberOfPawns = 0;

	/**
	* Constructs a default white Pawn
	*
	*/
	public Pawn() {
		this.color = WHITE;
		this.name = 'p';
		numberOfPawns = numberOfPawns + 1;
	}

	/**
	* Constructs a Pawn with a given color
	*
	* @param color og the pawn
	*/
	public Pawn(String color, Character name) {
		this.color = color;
		this.name = name;

		if (color != BLANK)  // cheat and use 'if'
			numberOfPawns = numberOfPawns + 1;
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
	public static void resetNumberPawns() {
		numberOfPawns = 0;
	}

	public static int getNumberPawns() {
		return numberOfPawns;
	}
}
