package persistance;

import model.Avion;
import model.User;


public interface IPersistance {
	public void stockerAvion (Avion avion) throws Exception;
	public Avion trouverQvion (String immat);
	public void addUser(User user) throws Exception ;
}
