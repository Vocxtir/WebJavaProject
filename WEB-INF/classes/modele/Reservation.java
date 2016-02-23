package modele;

public class Reservation {
	private User client;
	private int numVol;
	private String destination;
	private String dateDepart;
	private int nbPlacesSouhaitées;
	
	public Reservation(User client, String destination, String dateDepart, int nbPlacesSouhaitées) {
		this.client = client;
		this.destination = destination;
		this.dateDepart = dateDepart;
		this.nbPlacesSouhaitées = nbPlacesSouhaitées;
	}
}
