package persistance;

import model.Vol;
import model.User;


public interface IPersistance {
	public void stockerVol (Vol vol) throws Exception;
	public Vol trouverVol (int numVol);
	public void addUser(User user) throws Exception ;
	public void addVol(int numVol, Vol vol);
}
