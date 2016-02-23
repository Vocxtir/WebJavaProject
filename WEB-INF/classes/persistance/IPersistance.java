package persistance;

import model.Avion;
import model.Reservation;
import model.User;


public interface IPersistance {
	public void addAvion (Avion avion) throws Exception;
	public Avion trouverQvion (String immat);
	public void addUser(User user) throws Exception ;
	public void addReservation(Reservation reservation) throws Exception ;
}
