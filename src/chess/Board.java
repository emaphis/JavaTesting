package chess;

import java.util.ArrayList;
import chess.pieces.Pawn;

public class Board {
	private ArrayList<Pawn> pawns = new ArrayList<>();

	public Board() {

	}

	public int getNumberOfPawns() {
		return pawns.size();
	}

	public void addPawn(Pawn pawn) {
		pawns.add(pawn);
	}

	public Pawn getPawn(int index) {
		return pawns.get(index);
	}

}
