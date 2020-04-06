package action;

import view.LoginView;

public class Login extends Action{
	Login loginAction;

	@Override
	public void setAction(Action action) {
		this.loginAction = (Login)action;
	}

	public void index() {
		//画面の呼び出し
		new LoginView(loginAction).dispLogin();
	}

	public void login() {
		//ここから先は後から
	}

}
