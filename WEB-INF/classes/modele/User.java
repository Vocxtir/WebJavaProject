package modele;

public class User {
	private String login ;
	private String password ;
	private String role;
	
	public User (String log, String passw) {
		this.login = log ;
		this.password = passw ;
		this.role = "client";
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", role="
				+ role + "]";
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}
}
