package chess.pieces;

public class Piece {
	final private Color color;
	final private Type type;
	private static int whiteCount;
	private static int blackCount;

	public enum Color { WHITE, BLACK, NONE };
	public enum Type { PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, NONE };

	private Piece(Type type, Color color) {
		this.color = color;
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}

	//"PRNBQK"
	public String getRepresentation() {
		String representaion = new String();
		if (type == Type.PAWN) representaion = "p";
		else if (type == Type.ROOK) representaion = "r";
		else if (type == Type.KNIGHT) representaion = "n";
		else if (type == Type.BISHOP) representaion = "b";
		else if (type == Type.QUEEN) representaion = "q";
		else if (type == Type.KING)  representaion = "k";
		else return ".";

		if (color.equals(Color.BLACK))
			representaion = representaion.toUpperCase();

		return representaion;
	}


	public double getStrengthOfPiece() {
		if (type == Type.PAWN) return 1;
		else if (type == Type.ROOK) return 5;
		else if (type == Type.KNIGHT) return 2.5;
		else if (type == Type.BISHOP) return 3;
		else if (type == Type.QUEEN) return 9;
		
		return 0;
	}

	public boolean isWhite() {
		return this.color == Color.WHITE;
	}

	public boolean isBlack() {
		return this.color == Color.BLACK;
	}


	// factory methods
	public static Piece createWhite(Type type)
	{
		whiteCount++;
		return new Piece(type, Color.WHITE);
	}

	public static Piece createBlack(Type type) {
		blackCount++;
		return new Piece(type, Color.BLACK);
	}


	public static Piece createNullPiece()
	{
		return new Piece(Type.NONE, Color.NONE);
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
