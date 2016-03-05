package modele;


import controleur.ControlServlet;

public class UserSA {
	public static void createUser (String username, String password) throws Exception {
		
		if (ControlServlet.persist.findUserByName(username))
			throw new Exception("Utilisateur existant");
		User u = new User (username,password);
		ControlServlet.persist.addUser(u);
	}
	
	public static boolean authentificateUser(String username, String password){
		if (ControlServlet.persist.authentificateUser(new User(username, password)))
			return true ;	
		return false ;
	}
}
