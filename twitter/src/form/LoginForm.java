package form;

public class LoginForm {
	//シングルトン
	private static LoginForm loginForm;

	private LoginForm() {
	}

	//インスタンス取得用
	public static LoginForm getInstance(){
        if(loginForm == null){
            loginForm = new LoginForm();
        }
        return loginForm;
    }

	private String email;
	private String pass;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
