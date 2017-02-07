package chess.pieces;

public class Piece {
	private String color;
	static public String WHITE = "white";
	static public String BLACK = "black";
	private char representation = 'p';

	public Piece(String color, char r) {
		this.color = color;
		this.representation = r;
	}

	public Piece() {
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
