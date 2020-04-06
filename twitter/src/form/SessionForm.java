package form;

public class SessionForm {
	//シングルトン
	private static SessionForm sessionForm;

	private String loginUserName;

	private SessionForm() {
	}

	//インスタンス取得用
	public static SessionForm getInstance(){
        if(sessionForm == null){
            sessionForm = new SessionForm();
        }
        return sessionForm;
    }

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}
}
