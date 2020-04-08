package action;

import java.util.List;

import dto.LoginUserInfDto;
import form.LoginForm;
import form.SessionForm;
import service.UsersService;
import view.LoginView;

public class Login extends Action{
	//必要なサービスの呼び出し
	private UsersService usersService = new UsersService();

	//viewにクラスを渡したいので必ず自身のクラスのメンバを作ること
	private Login loginAction;

	//アクションクラスのインスタンスを自動生成する際に利用するので必須
	@Override
	public void setAction(Action action) {
		this.loginAction = (Login)action;
	}

	//必ず呼ばれる処理
	@Override
	public void index() {
		//画面の呼び出し
		new LoginView(loginAction).dispLogin();
	}

	//クラス固有の処理
	public void login() {
		//ログインチェック
		LoginForm loginForm = LoginForm.getInstance();
		List<LoginUserInfDto> checkList = usersService.selectLoginUserInf();
		boolean isLogin = false;

		for (LoginUserInfDto loginUserInfDto : checkList) {
			if(loginUserInfDto.getUsersEmail().equals(loginForm.getUsersEmail())
				&& loginUserInfDto.getUsersPassword().equals(loginForm.getUsersPassword())) {
				//ログイン成功時にセッションにログイン情報登録
				isLogin = true;
				SessionForm.getInstance().changeLogin(isLogin);
				SessionForm.getInstance().setLoginUserName(loginUserInfDto.getUsersName());
				break;
			}
		}

		//画面の呼び出し
		new LoginView(loginAction).dispCheckLogin(isLogin);
	}

}
