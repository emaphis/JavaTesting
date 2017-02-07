package chess;

import java.util.ArrayList;
import chess.pieces.Piece;
import chess.util.StringUtil;

public class Board {
	ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>();

	public Board() {
		this.initialize();
	}

	public void initialize() {
		board.add(0, createPieceRank(null, '.'));
		board.add(1, createPieceRank(Piece.BLACK, 'P'));
		board.add(2, createPieceRank(null, '.'));
		board.add(3, createPieceRank(null, '.'));
		board.add(4, createPieceRank(null, '.'));
		board.add(5, createPieceRank(null, '.'));
		board.add(6, createPieceRank(Piece.WHITE, 'p'));
		board.add(7, createPieceRank(null, '.'));
	}

	ArrayList<Piece> createPieceRank(String color, char representation) {
		ArrayList<Piece> rank = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			rank.add(new Piece(color, representation));
		}

		return rank;
	}

	public int getNumberOfPieces() {
		return board.get(1).size() + board.get(6).size();
	}


	public String getRankRepresentation(int index) {
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
			buffer.append(StringUtil.appendNewLine(getRankRepresentation(i)));
		}

		return buffer.toString();
	}
}
