package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Util.Message;
import root.Root;

public class Main {
	public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		try {
			while (true) {
				String inputLine = null;
		        Message.displayln("common_input");
		        inputLine = input.readLine();
				if(!Root.getInstance().actionExcute(inputLine))break;
			}
		} catch (IOException e) {
            e.printStackTrace();
        } finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
