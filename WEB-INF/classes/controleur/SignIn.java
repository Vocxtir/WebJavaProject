package controleur;

import modele.User;
import modele.UserSA;

public class SignIn{
	
	private User u;
	
	public SignIn(User u){
		this.u = u;
	}
	
	public boolean signIn(){
		return new UserSA().signInUser(u);
	}
}


