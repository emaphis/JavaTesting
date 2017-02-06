package chess;

import java.util.ArrayList;
import chess.pieces.Pawn;

public class Board {
	ArrayList<ArrayList<Pawn>> board = new ArrayList<ArrayList<Pawn>>();

	public Board() {
		this.initialize();
	}

	public void initialize() {
		board.add(0, createPawnRank(null, '.'));
		board.add(1, createPawnRank(Pawn.BLACK, 'P'));
		board.add(2, createPawnRank(null, '.'));
		board.add(3, createPawnRank(null, '.'));
		board.add(4, createPawnRank(null, '.'));
		board.add(5, createPawnRank(null, '.'));
		board.add(6, createPawnRank(Pawn.WHITE, 'p'));
		board.add(7, createPawnRank(null, '.'));
	}

	ArrayList<Pawn> createPawnRank(String color, char representation) {
		ArrayList<Pawn> rank = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			rank.add(new Pawn(color, representation));
		}

		return rank;
	}

	public int getNumberOfPawns() {
		return board.get(1).size() + board.get(6).size();
	}


	public String getRankRepresentation(int index) {
		ArrayList<Pawn> rank = board.get(index);
		StringBuilder buffer = new StringBuilder();

		for (Pawn pawn: rank) {
			buffer.append(pawn.getRepresentation());
		}

		return buffer.toString();
	}

	public String printBoard() {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < board.size(); i++) {
			buffer.append(getRankRepresentation(i) + "\n");
		}

		return buffer.toString();
	}
}
