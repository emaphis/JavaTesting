package chess;

import pieces.Pawn;
import java.util.*;

/**
* A board for a game of chess
*
* @author emaphis
*/
public class Board {
	ArrayList<Pawn> pawns = new ArrayList<>();

	/**
	 * @return number of Pawns on board
	 */
	int getNumber() {
		return pawns.size();
	}

	/**
	 * Adds a Pawn to the Board
	 *
	 * @param pawn
	 */
	void addPawn(Pawn pawn) {
		pawns.add(pawn);
	}

}
