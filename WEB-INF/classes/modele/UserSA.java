package modele;


import controleur.ControlServlet;

public class UserSA {
	public boolean createUser (User u) throws Exception {
		if (ControlServlet.persist.checkUser(u))
			return false;
		else {
			ControlServlet.persist.addUser(u);
			return true;
		}
	}
	
	public boolean signInUser(User u){
		if (ControlServlet.persist.checkUser(u))
			return true ;	
		return false ;
	}
}
