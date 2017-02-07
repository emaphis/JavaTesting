package chess.pieces;

public class Piece {
	final private Color color;
	final private String name;
	private static int whiteCount;
	private static int blackCount;

	public enum Color { WHITE, BLACK };
	//static final public String WHITE = "white";
	//static final public String BLACK = "black";

	private Piece(Color color, String name) {
		this.color = color;
		this.name = name;
	}

	Color getColor() {
		return color;
	}

	public String getRepresentation() {
		return name;
	}

	public boolean isWhite() {
		return this.color == Color.WHITE;
	}

	public boolean isBlack() {
		return this.color == Color.BLACK;
	}


	// factory method
	public static Piece create(Color color, String name) {
		if (color == Color.WHITE)
			whiteCount++;

		if (color == Color.BLACK)
			blackCount++;

		return new Piece(color, name);
	}

	public static void resetCount() {
		whiteCount = 0;
		blackCount = 0;
	}

	public static int getNumberOfWhite() {
		return whiteCount;
	}

	public static int getNumberOfBlack() {
		return blackCount;
	}
}
