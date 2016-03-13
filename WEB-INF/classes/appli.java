import modele.User;
import modele.UserSA;
import modele.Vol;
import persistance.PersistanceOracle;


public class appli {

	public static void main(String[] args) throws ClassNotFoundException {
		PersistanceOracle persistance= new PersistanceOracle();
		User u =new User("test", "test", "test", "test");
		Vol v = new Vol(54, "madrid", "04/04/2016", 50, 15);
		persistance.addVol(v);
		try {
			new UserSA().createUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
