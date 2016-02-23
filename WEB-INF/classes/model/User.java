package model;

public class User {
	private String login ;
	private String password ;
	
	public User (String log, String passw) {
		this.login = log ;
		this.password = passw ;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + "]";
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

}
