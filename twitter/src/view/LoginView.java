package view;

import java.io.IOException;

import Util.Message;
import action.Login;
import form.LoginForm;
import main.Main;

public class LoginView {
	private Login loginAction;

	public LoginView(Login loginAction) {
		this.loginAction = loginAction;
	}

	public void dispLogin() {
		try {
			Message.displayln("login_title");
			Message.display("login_mail");
		    LoginForm.getInstance().setEmail(Main.input.readLine());
			Message.display("login_pass");
			LoginForm.getInstance().setEmail(Main.input.readLine());
			Message.displayln();
			loginAction.login();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
