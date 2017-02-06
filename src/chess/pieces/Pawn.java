package chess.pieces;

public class Pawn {
	private String color;
	static public String WHITE = "white";
	static public String BLACK = "black";
	private char representation = 'p';

	public Pawn(String color, char r) {
		this.color = color;
		this.representation = r;
	}

	public Pawn() {
		this.color = WHITE;
		this.representation = 'p';
	}

	String getColor() {
		return color;
	}

	public char getRepresentation() {
		return representation;
	}
}
