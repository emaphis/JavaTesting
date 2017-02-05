package chess.pieces;

public class Pawn {
	private String color;
	static public String WHITE = "white";
	static public String BLACK = "black";

	public Pawn(String color) {
		this.color = color;
	}

	public Pawn() {
		this.color = WHITE;
	}

	String getColor() {
		return color;
	}
}
