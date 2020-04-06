package Util;

import java.text.MessageFormat;
import java.util.Map;

public class Message {
	public static void display(String key, Object... params) {
		final Map<String, String> messageMap = JsonReader.getMessageMap();
		String pattern = messageMap.get(key);
        System.out.print(MessageFormat.format(pattern, params));
	}

	public static void displayln(String key, Object... params) {
		final Map<String, String> messageMap = JsonReader.getMessageMap();
		String pattern = messageMap.get(key);
        System.out.println(MessageFormat.format(pattern, params));
	}

	public static void displayln() {
        System.out.println("");
	}
}
