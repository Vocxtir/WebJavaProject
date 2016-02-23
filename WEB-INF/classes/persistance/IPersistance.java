package persistance;

import modele.Reservation;
import modele.User;
import modele.Vol;


public interface IPersistance {
	public void stockerVol (Vol vol) throws Exception;
	public Vol trouverVol (int numVol);
	public void addUser(User user) throws Exception ;
	public void addVol(Vol vol);
	public void addReservation(Reservation v);
}
