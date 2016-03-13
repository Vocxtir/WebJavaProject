package controleur;

import modele.User;
import modele.UserSA;

public class CAuthentification {
	private UserSA SA;
	
	public CAuthentification (){
		SA = new UserSA();
	}
	
	public boolean signIn(User u){
		return SA.signInUser(u);
	}
	
	public boolean signUp(User u){
		try {
			SA.createUser(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.signIn(u);
	}
	
	public User getUser(User u){
		return SA.getUser(u);
	}
	
}

