package chess;

import java.util.*;


import chess.pieces.Piece;
import chess.util.StringUtil;

public class Board {
	ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>();

	public Board() {
	//	this.empty();
	}

	public void empty() {
		for (int index = 0; index < 8; ++index) {
			board.add(index, createPawnRank(Piece.Color.NONE));
		}
	}

	public void initialize() {
		board.add(0, createRank(Piece.Color.BLACK));
		board.add(1, createPawnRank(Piece.Color.BLACK));

		board.add(2, createNullRank());
		board.add(3, createNullRank());
		board.add(4, createNullRank());
		board.add(5, createNullRank());

		board.add(6, createPawnRank(Piece.Color.WHITE));
		board.add(7, createRank(Piece.Color.WHITE));
	}

	ArrayList<Piece> createNullRank() {
		return createPawnRank(Piece.Color.NONE);
	}

	ArrayList<Piece> createRank(Piece.Color color) {
		ArrayList<Piece> rank = new ArrayList<>();
		rank.add(0, createPiece(color, Piece.Type.ROOK));
		rank.add(1, createPiece(color, Piece.Type.KNIGHT));
		rank.add(2, createPiece(color, Piece.Type.BISHOP));
		rank.add(3, createPiece(color, Piece.Type.QUEEN));
		rank.add(4, createPiece(color, Piece.Type.KING));
		rank.add(5, createPiece(color, Piece.Type.BISHOP));
		rank.add(6, createPiece(color, Piece.Type.KNIGHT));
		rank.add(7, createPiece(color, Piece.Type.ROOK));
		return rank;
	}

	private ArrayList<Piece> createPawnRank(Piece.Color color) {
		ArrayList<Piece> pawnRank = new ArrayList<>();
		for (int index = 0; index < 8; ++index) {
			pawnRank.add(index, createPiece(color, Piece.Type.PAWN));
		}
		return pawnRank;
	}

	private Piece createPiece(Piece.Color color, Piece.Type type)
	{
		if (Piece.Color.WHITE == color)
			return Piece.createWhite(type);
		else if (Piece.Color.BLACK == color)
			return Piece.createBlack(type);
		else return Piece.createNullPiece();
	}

	// Piece handling
	public int getNumberOfPieces() {
		return Piece.getNumberOfWhite() + Piece.getNumberOfBlack();
	}

	public String getRankName(int index) {
		ArrayList<Piece> rank = board.get(index);
		StringBuilder buffer = new StringBuilder();

		for (Piece piece: rank) {
			buffer.append(piece.getRepresentation());
		}

		return buffer.toString();
	}

	public String printBoard() {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < board.size(); i++) {
			buffer.append(StringUtil.appendNewLine(getRankName(i)));
		}

		return buffer.toString();
	}

	public int getNumberOfAPiece(Piece.Type type, Piece.Color color) {
		int count = 0;
		for (List<Piece> rank: board) {
			for (Piece piece: rank) {
				if (piece.getType().equals(type) && piece.getColor().equals(color))
					count++;
			}
		}
		return count;
	}

	int invertIndex(int index) {
		return -(index-7) + 1;
	}

	Piece getAt(String location) {
		char[] array = location.toCharArray();
		int file = array[0] - 'a';
		int rank = invertIndex(Integer.parseInt("" + array[1]));

		Piece piece = board.get(rank).get(file);

		//System.out.print(location + " : " + file + " : " + rank + " : ");
		//System.out.println(piece.getType() + " : " + piece.getColor() + " : " + piece.getRepresentation());

		return piece;
	}

	public void setAt(Piece piece, String location) {
		char[] array = location.toCharArray();
		int file = array[0] - 'a';
		int rank = invertIndex(Integer.parseInt("" + array[1]));
		ArrayList<Piece> row = board.get(rank);
		row.set(file, piece);
		board.set(rank, row);
	}


	public double assesStrength(Piece.Color color) {
		double accum = 0.0;
		int rankIndex = 0;
		int fileIndex = 0;
		for (ArrayList<Piece> rank: board) {
			fileIndex++;
			rankIndex = 0;
			for (Piece piece: rank) {
				rankIndex++;
				if (piece.getColor().equals(color)) {
					if (piece.getType().equals(Piece.Type.PAWN))
						accum += getPawnStrength(piece.getColor(), fileIndex, rankIndex);
					else
						accum += piece.getStrengthOfPiece();
				}	
			}
					}
		return accum;
	}

	 double getPawnStrength(Piece.Color color, int fileIndex, int rankIndex) {
		 int count = 0;
		 for (ArrayList<Piece> rank: board) {
			 count++;
			 Piece piece = rank.get(fileIndex);
			 if (count != rankIndex )
				 if (piece.getType().equals(Piece.Type.PAWN) &&
					 piece.getColor().equals(color))
					 return 0.5;
		}
		return 1.0;
	}
}
