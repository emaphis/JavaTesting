package pieces;

import org.junit.Test;

import junit.framework.TestCase;

public class PawnTest extends TestCase {
	String WHITE = "white";
	String BLACK = "black";

	@Test
	public void testCreat() {
		Pawn pawn = new Pawn(WHITE);
		assertEquals(WHITE, pawn.getColor());

		Pawn pawn2 = new Pawn(BLACK);
		assertEquals(BLACK, pawn2.getColor());
	}

}
