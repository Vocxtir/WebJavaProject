package model;

public class Reservation {
	private User client;
	private int numVol;
	private String destination;
	private String dateDepart;
	private int nbPlacesSouhait�es;
	
	public Reservation(User client, String destination, String dateDepart, int nbPlacesSouhait�es) {
		this.client = client;
		this.destination = destination;
		this.dateDepart = dateDepart;
		this.nbPlacesSouhait�es = nbPlacesSouhait�es;
	}
}
