package pieces;

import org.junit.Test;

import junit.framework.TestCase;

public class PawnTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		Pawn.resetNumberPawns();
		//super.setUp();
	}

	@Test
	public void testCreate() {
		Pawn pawn1 = new Pawn(Pawn.BLACK, 'P');
		assertEquals(Pawn.BLACK, pawn1.getColor());

		Pawn pawn2 = new Pawn(Pawn.WHITE, 'p');
		assertEquals(Pawn.WHITE, pawn2.getColor());
	}

	@Test
	public void testDefaultPawn() {
		Pawn pawn = new Pawn();
		assertEquals(Pawn.WHITE, pawn.getColor());
		assertEquals(new Character('p'), pawn.getName());

	}

	@Test
	public void testGetName() {
		Pawn pawn1 = new Pawn(Pawn.WHITE, 'p');
		assertEquals(new Character('p'), pawn1.getName());

		Pawn pawn2 = new Pawn(Pawn.BLACK, 'P');
		assertEquals(new Character('P'), pawn2.getName());

		Pawn pawn3 = new Pawn(Pawn.BLANK, '.');
		assertEquals(new Character('.'),pawn3.getName()); // test my cheet.
	}

	@Test
	public void testGetNumberOfPawns() {
		Pawn.resetNumberPawns();
		assertEquals(0, Pawn.getNumberPawns());
		new Pawn();
		assertEquals(1, Pawn.getNumberPawns());
		new Pawn();
		assertEquals(2, Pawn.getNumberPawns());

		// null pawns shouldn't update pawn count
		new Pawn(Pawn.BLANK, '.');
		assertEquals(2, Pawn.getNumberPawns());
	}
}
