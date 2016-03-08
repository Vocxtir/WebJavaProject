package modele;

public class User {
	private String login;
	private String password;
	private String role;
	private String name;
	private String lastname;
	
	public User (String log, String passw, String name, String lastname) {
		this.login = log ;
		this.password = passw ;
		this.name = name;
		this.lastname = lastname;
		this.role = "client";
	}

	public String getNom() {
		return name;
	}

	public String getPrenom() {
		return lastname;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", role="
				+ role + ", nom=" + name + ", prenom=" + lastname + "]";
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
