package chess.pieces;

public class Piece {
	final private String color;
	final private String name;

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

	// factory method
	public static Piece create(String color, String name) {
		return new Piece(color, name);
	}
}
