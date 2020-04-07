package Util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {
	public static ArrayList<Map<String, String>> getCsvList(String csvName) {
		ArrayList<Map<String, String>> csvList =  new ArrayList<Map<String,String>>();
		List<String> readList = new ArrayList<String>();

		try {
//		      File f = new File(Paths.get(System.getProperty("user.dir") + "/db/csv/users.csv"));
			FileInputStream file = new FileInputStream("/Users/nao/desktop/wcp/Twitter_clone/twitter/db/csv/" + csvName + ".csv");
			InputStreamReader f = new InputStreamReader(file);
		    BufferedReader br = new BufferedReader(f);

		      String line;

		      // 1行ずつCSVファイルを読み込む
		      while ((line = br.readLine()) != null) {
		    	  readList.add(line);
		      }
		      br.close();

		    } catch (IOException e) {
		      System.out.println(e);
		    }


		String[] usersKeys = readList.get(0).split(",");

		readList.remove(0);

		for (String line : readList) {
			Map<String, String> map = new HashMap<String, String>();
			String[] items = line.split(",");
			for (int i = 0; i < usersKeys.length; i++) {
				map.put(usersKeys[i], items[i]);

			}
			csvList.add(map);
		}


		return csvList;
	}
}
