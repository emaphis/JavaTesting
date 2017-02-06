package chess.pieces;

import org.junit.Test;

import junit.framework.TestCase;

public class PawnTest extends TestCase {

	@Test
	public void testCreate() {
		Pawn firstPawn = new Pawn();
		assertEquals(Pawn.WHITE, firstPawn.getColor());
		assertEquals('p', firstPawn.getRepresentation());

		Pawn secondPawn = new Pawn(Pawn.BLACK, 'P');
		assertEquals(Pawn.BLACK, secondPawn.getColor());
		assertEquals('P', secondPawn.getRepresentation());
	}


}
