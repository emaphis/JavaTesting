package chess.pieces;

public class Piece {
	final private String color;
	final private String name;
	private static int whiteCount;
	private static int blackCount;

	static final public String WHITE = "white";
	static final public String BLACK = "black";

	private Piece(String color, String name) {
		this.color = color;
		this.name = name;
	}

	String getColor() {
		return color;
	}

	public String getRepresentation() {
		return name;
	}

	public boolean isWhite() {
		return this.color == Piece.WHITE;
	}

	public boolean isBlack() {
		return this.color == Piece.BLACK;
	}


	// factory method
	public static Piece create(String color, String name) {
		if (color == WHITE)
			whiteCount++;

		if (color == BLACK)
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
