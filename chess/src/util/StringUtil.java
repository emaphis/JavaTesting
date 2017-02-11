package util;

public class StringUtil {
	public static final String NEW_LINE = System.getProperty("line.separator");

	private StringUtil() { };

	public static String  appendNewLine(String str) {
		return str + NEW_LINE;
	}
}
