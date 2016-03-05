package modele;

import java.util.ArrayList;
import java.util.List;

import controleur.ControlServlet;

public class ReservationSA {

	public static void creerReservation(User client, String destination, String dateDepart, int nbPlacesSouhait�es) throws Exception{
		ControlServlet.persist.addReservation(new Reservation(client, destination, dateDepart, nbPlacesSouhait�es));
	}
	
	public static List<Reservation> displayReservation (){
		return new ArrayList<Reservation>() ;
	}
}
