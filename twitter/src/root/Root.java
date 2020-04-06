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
import action.Login;

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
				Action action = (Action)Class.forName("action."+ name).newInstance();
				action.setAction(action);
				actionMap.put(name, action);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		});
	}

	public boolean actionExcute(String inputLine) {
		switch (matchCommand(inputLine.split(" ")[0])) {
			case TWEET:
				return true;
			case FOLLOW:
				return true;
			case EXIT:
				Message.displayln("common_exit_app");
				return false;
			case LOGIN:
				((Login)actionMap.get("Login")).index();
				return true;
			case ERROR:
				Message.displayln("error_re_enter");
				return true;
		}
		return false;
	}

	//インスタンス取得用
	public static Root getInstance(){
        if(root == null){
            root = new Root();
        }
        return root;
    }

	//コマンド略称から一致したコマンド名を抽出
	private Command matchCommand(String inputCommand) {
		Command[] commands = Command.values();
		Command selectCommand = Command.ERROR;
		for(Command command: commands) {
			selectCommand = command.getAbbr().equals(inputCommand) ? command : Command.ERROR;
			if(selectCommand != Command.ERROR)break;
		}
		return selectCommand;
	}
}
