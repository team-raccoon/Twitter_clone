package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Util.Message;
import root.Root;

public class Main {

	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				String inputLine = null;
		        Message.display("common_input");
		        inputLine = input.readLine();
		        Message.display("debug_input_confirm", inputLine);
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
