package chess;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import java.util.*;

import static util.StringUtil.appendNewLine;;

/**
* A board for a game of chess
*
* @author emaphis
*/
public class Board {
	List<List<Piece>> ranks = new ArrayList<>();

	// sorted Piece lists.
	List<Piece> whiteStrengthList = new ArrayList<>();
	List<Piece> blackStrengthList = new ArrayList<>();

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
	void initialize() {
		ranks.clear();
		Piece.resetNumberPieces();
		ranks.add(createPieceRank(Piece.Color.WHITE));
		ranks.add(createPawnRank(Piece.Color.WHITE));
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createPawnRank(Piece.Color.BLACK));
		ranks.add(createPieceRank(Piece.Color.BLACK));
	}

	void clearBoard() {
		ranks.clear();
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		ranks.add(createEmptyRank());
		Piece.resetNumberPieces();
	}

	List<Piece> createPawnRank(Piece.Color color) {
		List<Piece> rank = new ArrayList<>();
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

	List<Piece> createPieceRank(Piece.Color color) {
		List<Piece> rank = new ArrayList<>();
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

	List<Piece> createEmptyRank() {
		List<Piece> rank = new ArrayList<>();
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


	public int getNumberOAfPiece(Piece.Color color, Piece.Type type) {
		int count = 0;
		for (List<Piece> rank: ranks) {
			for (Piece piece: rank) {
				if (piece.getColor() == color &&  piece.getType() == type)
					count = count + 1;
			}
		}
		return count;
	}

	/**
	 * functions that convert an alphanumeric coordinate to
	 *  suitable for zero based array indexing
	 *
	 *  array[0] is a letter representing file of board
	 *  array[1] is a single digit in char form representing
	 *  1 based rank of board
	 *
	 * "a1" should produce 0,0
	 * "a8" should produce 0,7
	 * "e1" should produce 4,0
	 */
	public int getRankIdx(String coordinate) {
		char[] array = coordinate.toCharArray();
		int rankIdx = Integer.parseInt(String.valueOf(array[1])) - 1;
		return rankIdx;
	}

	public int getFileIdx(String coordinate) {
		char[] array = coordinate.toCharArray();
		int fileIdx = array[0] - 'a';
		return fileIdx;
	}

	public Piece getAt(String coordinate) {
		int rankIdx = getRankIdx(coordinate);
		int fileIdx = getFileIdx(coordinate);

		List<Piece> rank = ranks.get(rankIdx);
		return rank.get(fileIdx);
	}


	public void setAt(Piece piece, String coordinate) {
		int rankIdx = getRankIdx(coordinate);
		int fileIdx = getFileIdx(coordinate);

		List<Piece> rank = ranks.get(rankIdx);
		rank.set(fileIdx, piece);
		ranks.set(rankIdx, rank);
	}

	public double getStrength(Color color) {
		double totalStrength = 0.0;

		if (color == Color.BLACK)
			whiteStrengthList.clear();
		else
			blackStrengthList.clear();

		int rankIdx = 0;
		for (List<Piece> rank: ranks) {
			int fileIdx = 0;
			for (Piece piece: rank) {
				if (piece.getColor() == color) {
					double strength = 0.0;
					if (piece.getType() == Type.PAWN)
						strength = getPawnStrength(rankIdx, fileIdx, piece);
					else
						strength = Piece.getTypeStrength(piece.getType());

					totalStrength += strength;

					piece.setStrength(strength);
					if (color == Color.WHITE)
						whiteStrengthList.add(piece);
					else
						blackStrengthList.add(piece);
				}
				totalStrength += 0.0;
				fileIdx++;
			}
			rankIdx++;
		}
		return totalStrength;
	}

	public double  getPawnStrength(int rankIdx, int fileIdx, Piece pawn) {
		int index = 0;
		for (List<Piece> rank: ranks) {
			if (index != rankIdx) {
				Piece piece = rank.get(fileIdx);
				if (piece.getColor() == pawn.getColor() &&
					  piece.getType() == Type.PAWN){
					return Piece.getTypeStrength(pawn.getType()) * 0.5; // passed pawn
				}
			}
			// else  { skip rank }
			index++;
		}
		return Piece.getTypeStrength(pawn.getType());  // full pawn
	}

	public List<Piece> getStrengthList(Color color) {
		List<Piece> strengthList = null;
		if (color == Color.WHITE)
			strengthList = whiteStrengthList;
		else
			strengthList = blackStrengthList;

		Collections.sort(strengthList);
		return strengthList;
	}

	public static void main(String[] args) {

	}
}
