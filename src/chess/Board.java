package chess;

import java.util.*;


import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.util.StringUtil;

public class Board {
	ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>();

	public Board() {
		//this.initialize();
	}

	public void initialize() {
		board.add(0, createBlackRank());
		board.add(1, createBlackPawnRank());

		board.add(2, createPieceRank(Piece.createNullPiece()));
		board.add(3, createPieceRank(Piece.createNullPiece()));
		board.add(4, createPieceRank(Piece.createNullPiece()));
		board.add(5, createPieceRank(Piece.createNullPiece()));

		board.add(6, createWhitePawnRank());
		board.add(7, createWhiteRank());
	}

	ArrayList<Piece> createPieceRank(Piece piece) {
		ArrayList<Piece> rank = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			rank.add(piece);
		}

		return rank;
	}

	ArrayList<Piece> createWhiteRank() {
		ArrayList<Piece> whiteRank = new ArrayList<>();
		whiteRank.add(0, Piece.createWhite(Piece.Type.ROOK));
		whiteRank.add(1, Piece.createWhite(Piece.Type.KNIGHT));
		whiteRank.add(2, Piece.createWhite(Piece.Type.BISHOP));
		whiteRank.add(3, Piece.createWhite(Piece.Type.QUEEN));
		whiteRank.add(4, Piece.createWhite(Piece.Type.KING));
		whiteRank.add(5, Piece.createWhite(Piece.Type.BISHOP));
		whiteRank.add(6, Piece.createWhite(Piece.Type.KNIGHT));
		whiteRank.add(7, Piece.createWhite(Piece.Type.ROOK));
		return whiteRank;
	}

	ArrayList<Piece> createBlackRank() {
		ArrayList<Piece> blackRank = new ArrayList<>();
		blackRank.add(0, Piece.createBlack(Piece.Type.ROOK));
		blackRank.add(1, Piece.createBlack(Piece.Type.KNIGHT));
		blackRank.add(2, Piece.createBlack(Piece.Type.BISHOP));
		blackRank.add(3, Piece.createBlack(Piece.Type.QUEEN));
		blackRank.add(4, Piece.createBlack(Piece.Type.KING));
		blackRank.add(5, Piece.createBlack(Piece.Type.BISHOP));
		blackRank.add(6, Piece.createBlack(Piece.Type.KNIGHT));
		blackRank.add(7, Piece.createBlack(Piece.Type.ROOK));

		return blackRank;
	}

	ArrayList<Piece> createWhitePawnRank() {
		ArrayList<Piece> whitePawnRank = new ArrayList<>();
		whitePawnRank.add(0, Piece.createWhite(Piece.Type.PAWN));
		whitePawnRank.add(1, Piece.createWhite(Piece.Type.PAWN));
		whitePawnRank.add(2, Piece.createWhite(Piece.Type.PAWN));
		whitePawnRank.add(3, Piece.createWhite(Piece.Type.PAWN));
		whitePawnRank.add(4, Piece.createWhite(Piece.Type.PAWN));
		whitePawnRank.add(5, Piece.createWhite(Piece.Type.PAWN));
		whitePawnRank.add(6, Piece.createWhite(Piece.Type.PAWN));
		whitePawnRank.add(7, Piece.createWhite(Piece.Type.PAWN));
		return whitePawnRank;
	}

	ArrayList<Piece> createBlackPawnRank() {
		ArrayList<Piece> blackPawnRank = new ArrayList<>();
		blackPawnRank.add(0, Piece.createBlack(Piece.Type.PAWN));
		blackPawnRank.add(1, Piece.createBlack(Piece.Type.PAWN));
		blackPawnRank.add(2, Piece.createBlack(Piece.Type.PAWN));
		blackPawnRank.add(3, Piece.createBlack(Piece.Type.PAWN));
		blackPawnRank.add(4, Piece.createBlack(Piece.Type.PAWN));
		blackPawnRank.add(5, Piece.createBlack(Piece.Type.PAWN));
		blackPawnRank.add(6, Piece.createBlack(Piece.Type.PAWN));
		blackPawnRank.add(7, Piece.createBlack(Piece.Type.PAWN));
		return blackPawnRank;
	}

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
			 if (count != rankIndex &&
					 piece.getType().equals(Piece.Type.PAWN) &&
					 piece.getColor().equals(color))
				 return 0.1;   // then their is a pawn in the same rank
			 else
				 return piece.getStrengthOfPiece();
		}
		return 0.0;
	}
}
