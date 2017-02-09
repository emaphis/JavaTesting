package examples;

import org.junit.Test;

import junit.framework.TestCase;

public class SuperClassTest extends TestCase {

	@Test
	public void testConstructorCalls() {
		SuperClass superClass = new SubClass("param");
		assertTrue(SuperClass.constructorWasCalled);
		assertEquals("param", superClass.getParam());
	}

}
