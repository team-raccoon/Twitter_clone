package root;

public enum Command {
	TWEET("tw"),
	FOLLOW("fw"),
	EXIT("exit"),
	LOGIN("login"),
	ERROR("error");

	private String abbr;

	private Command(String abbr) {
		this.abbr = abbr;
	}

	public String getAbbr() {
		return abbr;
	}
}
