package chess;

import org.junit.Test;

import junit.framework.TestCase;

public class PawnTest extends TestCase {

	@Test
	public void testCreate() {
		final String firstColor = "white";
		Pawn firstPawn = new Pawn(firstColor);
		assertEquals(firstColor, firstPawn.getColor());

		final String secondColor = "black";
		Pawn secondPawn = new Pawn(secondColor);
		assertEquals(secondColor, secondPawn.getColor());
	}

}
