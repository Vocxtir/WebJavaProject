import modele.User;
import modele.UserSA;
import persistance.PersistanceOracle;


public class appli {

	public static void main(String[] args) throws ClassNotFoundException {
		PersistanceOracle persistance= new PersistanceOracle();
		User u =new User("test", "test", "test", "test");
		try {
			new UserSA().createUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
