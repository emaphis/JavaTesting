package chess;

import pieces.Piece;
import java.util.*;
import static util.StringUtil.addNL;;

/**
* A board for a game of chess
*
* @author emaphis
*/
public class Board {
	ArrayList<ArrayList<Piece>> ranks = new ArrayList<>();

	/**
	 * @return number of Pawns on board
	 */
	int getNumber() {
		return Piece.getNumberPieces();
	}

	/**
	 * initialized the board with Pawns Pieces and empty squares
	 * Empty squares are represented by nulls.
	 *
	 * Creates ranks in order add one.
	 * 1st=0, 2nd=1, 3rd=2, 4th=3, 5th=4, 5th=5, 6th=5, 7th=6, 8th=7.
	 */
	void intialize() {
		Piece.resetNumberPieces();
		ranks.add(createPieceRank(Piece.WHITE));
		ranks.add(createPawnRank(Piece.WHITE, Piece.PAWN));
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createPawnRank(Piece.BLACK, Piece.PAWN));
		ranks.add(createPieceRank(Piece.BLACK));
	}

	ArrayList<Piece> createPawnRank(String color, String name) {
		ArrayList<Piece> rank = new ArrayList<>();
		rank.add(new Piece(color, name));
		rank.add(new Piece(color, name));
		rank.add(new Piece(color, name));
		rank.add(new Piece(color, name));
		rank.add(new Piece(color, name));
		rank.add(new Piece(color, name));
		rank.add(new Piece(color, name));
		rank.add(new Piece(color, name));
		return rank;
	}

	ArrayList<Piece> createPieceRank(String color) {
		ArrayList<Piece> rank = new ArrayList<>();
		rank.add(new Piece(color, Piece.ROOK));
		rank.add(new Piece(color, Piece.KNIGHT));
		rank.add(new Piece(color, Piece.BISHOP));
		rank.add(new Piece(color, Piece.QUEEN));
		rank.add(new Piece(color, Piece.KING));
		rank.add(new Piece(color, Piece.BISHOP));
		rank.add(new Piece(color, Piece.KNIGHT));
		rank.add(new Piece(color, Piece.ROOK));
		return rank;
	}

	ArrayList<Piece> createEmptyRank() {
		ArrayList<Piece> rank = new ArrayList<>();
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
		if (ranks.get(rankNum - 1).size() == 8) {
			StringBuilder builder = new StringBuilder();
			for (Piece pawn: ranks.get(rankNum-1)) {
				builder.append(pawn.getName());
			}
			return builder.toString();
		}
		else
			return "........";
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
