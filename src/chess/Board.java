package chess;

import java.util.ArrayList;
import chess.pieces.Piece;
import chess.util.StringUtil;

public class Board {
	ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>();

	public Board() {
		//this.initialize();
	}

	public void initialize() {
		ArrayList<Piece> blackRank = new ArrayList<>();
		blackRank.add(0, Piece.create(Piece.BLACK, "R"));
		blackRank.add(1, Piece.create(Piece.BLACK, "N"));
		blackRank.add(2, Piece.create(Piece.BLACK, "B"));
		blackRank.add(3, Piece.create(Piece.BLACK, "Q"));
		blackRank.add(4, Piece.create(Piece.BLACK, "K"));
		blackRank.add(5, Piece.create(Piece.BLACK, "B"));
		blackRank.add(6, Piece.create(Piece.BLACK, "N"));
		blackRank.add(7, Piece.create(Piece.BLACK, "R"));
		board.add(0, blackRank);

		board.add(1, createPieceRank(Piece.BLACK, "P"));

		board.add(2, createPieceRank(null, "."));
		board.add(3, createPieceRank(null, "."));
		board.add(4, createPieceRank(null, "."));
		board.add(5, createPieceRank(null, "."));

		board.add(6, createPieceRank(Piece.WHITE, "p"));

		ArrayList<Piece> whiteRank = new ArrayList<>();
		whiteRank.add(0, Piece.create(Piece.WHITE, "r"));
		whiteRank.add(1, Piece.create(Piece.WHITE, "n"));
		whiteRank.add(2, Piece.create(Piece.WHITE, "b"));
		whiteRank.add(3, Piece.create(Piece.WHITE, "q"));
		whiteRank.add(4, Piece.create(Piece.WHITE, "k"));
		whiteRank.add(5, Piece.create(Piece.WHITE, "b"));
		whiteRank.add(6, Piece.create(Piece.WHITE, "n"));
		whiteRank.add(7, Piece.create(Piece.WHITE, "r"));
		board.add(7, whiteRank);
	}

	ArrayList<Piece> createPieceRank(String color, String name) {
		ArrayList<Piece> rank = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			rank.add(Piece.create(color, name));
		}

		return rank;
	}

	public int getNumberOfPieces() {
		return board.get(1).size() + board.get(6).size();
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
}
