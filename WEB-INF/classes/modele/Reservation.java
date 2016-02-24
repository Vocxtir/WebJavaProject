package modele;

public class Reservation {
	private User client;
	private int numVol;
	private String destination;
	private String dateDepart;
	private int nbPlacesSouhait�es;
	
	public User getClient() {
		return client;
	}

	public String getDestination() {
		return destination;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public int getNbPlaces() {
		return nbPlacesSouhait�es;
	}
	public Reservation(User client, String destination, String dateDepart, int nbPlacesSouhait�es) {
		this.client = client;
		this.destination = destination;
		this.dateDepart = dateDepart;
		this.nbPlacesSouhait�es = nbPlacesSouhait�es;
	}
}
