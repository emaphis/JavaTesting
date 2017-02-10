package chess;

import pieces.Pawn;
import java.util.*;

/**
* A board for a game of chess
*
* @author emaphis
*/
public class Board {
	ArrayList<ArrayList<Pawn>> ranks = new ArrayList<>();
	public static final String NEW_LINE = System.getProperty("line.separator");

	/**
	 * @return number of Pawns on board
	 */
	int getNumber() {
		return Pawn.getNumberPawns();
	}

	/**
	 * initialized the board with Pawns Pieces and empty squares
	 * Empty squares are represented by nulls.
	 *
	 * Creates ranks in reverse order.
	 */
	void intialize() {
		Pawn.resetNumberPawns();
		ranks.add(createEmptyRank());
		ranks.add(createBlackPawnRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createWhitePawnRank());
		ranks.add(createEmptyRank());
	}

	ArrayList<Pawn> createWhitePawnRank() {
		ArrayList<Pawn> rank = new ArrayList<>();
		rank.add(new Pawn());
		rank.add(new Pawn());
		rank.add(new Pawn());
		rank.add(new Pawn());
		rank.add(new Pawn());
		rank.add(new Pawn());
		rank.add(new Pawn());
		rank.add(new Pawn());
		return rank;
	}

	ArrayList<Pawn> createBlackPawnRank() {
		ArrayList<Pawn> rank = new ArrayList<>();
		rank.add(new Pawn(Pawn.BLACK,'P'));
		rank.add(new Pawn(Pawn.BLACK,'P'));
		rank.add(new Pawn(Pawn.BLACK,'P'));
		rank.add(new Pawn(Pawn.BLACK,'P'));
		rank.add(new Pawn(Pawn.BLACK,'P'));
		rank.add(new Pawn(Pawn.BLACK,'P'));
		rank.add(new Pawn(Pawn.BLACK,'P'));
		rank.add(new Pawn(Pawn.BLACK,'P'));
		return rank;
	}

	ArrayList<Pawn> createEmptyRank() {
		ArrayList<Pawn> rank = new ArrayList<>();
		rank.add(new Pawn(Pawn.BLANK,'.'));
		rank.add(new Pawn(Pawn.BLANK,'.'));
		rank.add(new Pawn(Pawn.BLANK,'.'));
		rank.add(new Pawn(Pawn.BLANK,'.'));
		rank.add(new Pawn(Pawn.BLANK,'.'));
		rank.add(new Pawn(Pawn.BLANK,'.'));
		rank.add(new Pawn(Pawn.BLANK,'.'));
		rank.add(new Pawn(Pawn.BLANK,'.'));
		return rank;
	}

	/**
	 * Returns a string representation of a rank indexed from 1 to 8
	 *   with 1 being the bottom of the board
	 *
	 * @param rankNum (1-8)
	 * @return String of Piece names
	 */

	String getRankRepresentation(int rankNum) {
		StringBuilder builder = new StringBuilder();
		for (Pawn pawn: ranks.get(rankNum-1)) {
			builder.append(pawn.getName());
		}
		return builder.toString();
	}

	String getBoardRepresentation() {
		StringBuilder builder = new StringBuilder();
		builder.append(getRankRepresentation(1) + NEW_LINE);
		builder.append(getRankRepresentation(2) + NEW_LINE);
		builder.append(getRankRepresentation(3) + NEW_LINE);
		builder.append(getRankRepresentation(4) + NEW_LINE);
		builder.append(getRankRepresentation(5) + NEW_LINE);
		builder.append(getRankRepresentation(6) + NEW_LINE);
		builder.append(getRankRepresentation(7) + NEW_LINE);
		builder.append(getRankRepresentation(8) + NEW_LINE);

		return builder.toString();
	}

}
