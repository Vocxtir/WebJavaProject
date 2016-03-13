package persistance;

import modele.Reservation;
import modele.User;
import modele.Vol;


public interface IPersistance {
	public Vol trouverVol (int numVol);
	
	public void addUser(User user);
	public boolean checkUser(User u);
	public User getUser(String login);
	
	
	public void addVol(Vol vol);
	public void addReservation(Reservation v);

	
}
