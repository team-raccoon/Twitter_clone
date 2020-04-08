package form;

public class LoginForm {
	//シングルトン
	private static LoginForm loginForm;
	//呼び出されないように
	private LoginForm() {
	}

	//インスタンス取得用
	public static LoginForm getInstance(){
        if(loginForm == null){
            loginForm = new LoginForm();
        }
        return loginForm;
    }

	//以下からはbean
	private String usersEmail;
	private String usersPassword;
	private String usersName;

	public String getUsersEmail() {
		return usersEmail;
	}

	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}

	public String getUsersPassword() {
		return usersPassword;
	}

	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
}
