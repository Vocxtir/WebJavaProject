package modele;


import controleur.ControlServlet;

public class UserSA {
	public void createUser (User u) throws Exception {
		if (ControlServlet.persist.checkUser(u))
			throw new Exception("Utilisateur existant");
		else {
			ControlServlet.persist.addUser(u);
		}
	}
	
	public boolean signInUser(User u){
		if (ControlServlet.persist.checkUser(u))
			return true ;	
		return false ;
	}
}
