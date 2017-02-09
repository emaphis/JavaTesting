package examples;

abstract class SuperClass {

	static boolean constructorWasCalled = false;

	SuperClass() {
		constructorWasCalled = true;
	}

	abstract String getParam();
}
