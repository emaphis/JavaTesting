package pieces;

/**
* A pawn in a game of chess
*
* @author emaphis
*/
public class Pawn {
	public static final String WHITE = "white";
	public static final String BLACK = "black";
	private final String color;

	/**
	* Constructs a default white Pawn
	*
	*/
	public Pawn() {
		this.color = WHITE;
	}

	/**
	* Constructs a Pawn with a given color
	*
	* @param color og the pawn
	*/
	public Pawn(String color) {
		this.color = color;
	}

	/**
	* @return color of the Pawn
	*/
	String getColor() {
		return color;
	}

}
