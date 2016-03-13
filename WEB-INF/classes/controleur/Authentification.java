package controleur;

import modele.User;
import modele.UserSA;

public class Authentification {
	
	public boolean signIn(User u){
		return new UserSA().signInUser(u);
	}
	
	public boolean signUp(User u){
		try {
			return new UserSA().createUser(u);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}

