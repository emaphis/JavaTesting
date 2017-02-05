package chess.pieces;

import org.junit.Test;

import junit.framework.TestCase;

public class PawnTest extends TestCase {

	@Test
	public void testCreate() {
		Pawn firstPawn = new Pawn(Pawn.WHITE);
		assertEquals(Pawn.WHITE, firstPawn.getColor());

		Pawn secondPawn = new Pawn(Pawn.BLACK);
		assertEquals(Pawn.BLACK, secondPawn.getColor());
	}

	@Test
	public void testCreatePawnWithoutColor() {
		Pawn colorlessPawn = new Pawn();
		assertEquals(Pawn.WHITE, colorlessPawn.getColor());
	}

}
