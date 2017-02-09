package examples;

class SubClass extends SuperClass {
	String data;
	SubClass(String param) {
		data = param;
	}

	@Override
	String getParam() {
		return data;
	}
}
