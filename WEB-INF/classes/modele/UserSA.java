package modele;


import controleur.ControlServlet;

public class UserSA {
	public static void createUser (User u) throws Exception {
		
		if (ControlServlet.persist.checkUser(u))
			throw new Exception("Utilisateur existant");
		else {
			ControlServlet.persist.addUser(u);
		}
	}
	
	public static boolean authentificateUser(User u){
		if (ControlServlet.persist.authentificateUser(u))
			return true ;	
		return false ;
	}
}
