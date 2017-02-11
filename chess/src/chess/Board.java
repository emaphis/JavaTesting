package chess;

import pieces.Piece;
//import pieces.Piece.*;
import java.util.*;
import static util.StringUtil.appendNewLine;;

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
	int getPieceCount() {
		return Piece.getPieceCount(Piece.Color.WHITE) +
				Piece.getPieceCount(Piece.Color.BLACK);
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
		ranks.clear();
		ranks.add(createPieceRank(Piece.Color.WHITE));
		ranks.add(createPawnRank(Piece.Color.WHITE));
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createPawnRank(Piece.Color.BLACK));
		ranks.add(createPieceRank(Piece.Color.BLACK));
	}

	ArrayList<Piece> createPawnRank(Piece.Color color) {
		ArrayList<Piece> rank = new ArrayList<>();
		rank.add(Piece.createPawn(color));
		rank.add(Piece.createPawn(color));
		rank.add(Piece.createPawn(color));
		rank.add(Piece.createPawn(color));
		rank.add(Piece.createPawn(color));
		rank.add(Piece.createPawn(color));
		rank.add(Piece.createPawn(color));
		rank.add(Piece.createPawn(color));
		return rank;
	}

	ArrayList<Piece> createPieceRank(Piece.Color color) {
		ArrayList<Piece> rank = new ArrayList<>();
		rank.add(Piece.createRook(color));
		rank.add(Piece.createKnight(color));
		rank.add(Piece.createBishop(color));
		rank.add(Piece.createQueen(color));
		rank.add(Piece.createKing(color));
		rank.add(Piece.createBishop(color));
		rank.add(Piece.createKnight(color));
		rank.add(Piece.createRook(color));
		return rank;
	}

	ArrayList<Piece> createEmptyRank() {
		ArrayList<Piece> rank = new ArrayList<>();
		rank.add(Piece.noPiece());
		rank.add(Piece.noPiece());
		rank.add(Piece.noPiece());
		rank.add(Piece.noPiece());
		rank.add(Piece.noPiece());
		rank.add(Piece.noPiece());
		rank.add(Piece.noPiece());
		rank.add(Piece.noPiece());
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
		for (Piece piece: ranks.get(rankNum-1)) {
			builder.append(piece.getRepresentation());
		}
		return builder.toString();
	}

	// print board in reverse order, low ranks at bottom.
	String print() {
		return
			appendNewLine(getRankRepresentation(8)) +
			appendNewLine(getRankRepresentation(7)) +
			appendNewLine(getRankRepresentation(6)) +
			appendNewLine(getRankRepresentation(5)) +
			appendNewLine(getRankRepresentation(4)) +
			appendNewLine(getRankRepresentation(3)) +
			appendNewLine(getRankRepresentation(2)) +
			appendNewLine(getRankRepresentation(1));
	}
}
