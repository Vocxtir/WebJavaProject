package controleur;

import modele.User;
import modele.UserSA;

public class Authentification {
	private UserSA SA;
	
	public Authentification (){
		SA = new UserSA();
	}
	
	public boolean signIn(User u){
		boolean retour = SA.signInUser(u);
		u = SA.getUser(u);
		return retour;
	}
	
	public boolean signUp(User u){
		try {
			SA.createUser(u);
			u = SA.getUser(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.signIn(u);
	}
	
}

