package Util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JsonReader {
	public static Map<String, String> getMessageMap() {
		final String fileName = System.getProperty("user.dir")+"/property/message.json";
        String script = null;
        // 設定にあるクラス名を取得
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            script = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            	    .toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        Map<String, String> messageMap = new HashMap<>();
        try {
            // JavaScriptの実行
            Object obj = engine.eval(String.format("(%s)", script));
            // リフレクションでキーセットを取得
            Object[] keys = ((Set<?>)obj.getClass().getMethod("keySet").invoke(obj)).toArray();
            // リフレクションでgetメソッドを取得
            Method method_get = obj.getClass().getMethod("get", Class.forName("java.lang.Object"));

            for(Object key : keys) {
                Object val = method_get.invoke(obj, key);
                messageMap.put(key.toString(), val.toString());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
		return messageMap;
	}
}
