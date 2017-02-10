package pieces;

import org.junit.Test;

import junit.framework.TestCase;

public class PawnTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		//super.setUp();
	}

	@Test
	public void testCreate() {
		Pawn pawn1 = new Pawn(Pawn.BLACK);
		assertEquals(Pawn.BLACK, pawn1.getColor());

		Pawn pawn2 = new Pawn ();  // test default constructor
		assertEquals(Pawn.WHITE, pawn2.getColor());
	}

	@Test
	public void testDefaultPawn() {
		Pawn pawn = new Pawn();
		assertEquals(Pawn.WHITE, pawn.getColor());

	}
}
