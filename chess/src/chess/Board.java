package chess;

import pieces.Pawn;
import java.util.*;
import static util.StringUtil.addNL;;

/**
* A board for a game of chess
*
* @author emaphis
*/
public class Board {
	ArrayList<ArrayList<Pawn>> ranks = new ArrayList<>();

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
	 * Creates ranks in order add one.
	 * 1st=0, 2nd=1, 3rd=2, 4th=3, 5th=4, 5th=5, 6th=5, 7th=6, 8th=7.
	 */
	void intialize() {
		Pawn.resetNumberPawns();
		ranks.add(createEmptyRank());
		ranks.add(createWhitePawnRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createBlackPawnRank());
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

	// print board in reverse order, low ranks at bottom.
	String getBoardRepresentation() {
		StringBuilder builder = new StringBuilder();
		builder.append(addNL(getRankRepresentation(8)));
		builder.append(addNL(getRankRepresentation(7)));
		builder.append(addNL(getRankRepresentation(6)));
		builder.append(addNL(getRankRepresentation(5)));
		builder.append(addNL(getRankRepresentation(4)));
		builder.append(addNL(getRankRepresentation(3)));
		builder.append(addNL(getRankRepresentation(2)));
		builder.append(addNL(getRankRepresentation(1)));
		return builder.toString();
	}
}
