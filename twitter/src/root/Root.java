package root;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Util.Message;
import action.Action;

public class Root {
	//シングルトン
	private static Root root;
	private Map<String, Action> actionMap = new HashMap<String, Action>();

	private Root() {
		final String fileName = System.getProperty("user.dir")+"/property/actionClassName.txt";
        List<String> actionClassNames = new ArrayList<>();
        // 設定にあるクラス名を取得
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            actionClassNames = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
		//　設定にあるクラスのインスタンスを自動生成
		actionClassNames.stream().forEach((final String name) -> {
			try {
				actionMap.put(name, (Action)Class.forName("action."+ name).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		});
	}

	public boolean actionExcute(String inputLine) {
		switch (inputLine.split(" ")[0]) {
			case "tw":
				return true;
			case "fw":
				return true;
			case "exit":
				Message.display("common_exit_app");
				return false;
			default :
				Message.display("error_re_enter");
				return true;
		}
	}

	//インスタンス取得用
	public static Root getInstance(){
        if(root == null){
            root = new Root();
        }
        return root;
    }
}
