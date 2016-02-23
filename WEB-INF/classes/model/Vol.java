package model;

import java.io.Serializable;

public class Vol implements Serializable{

	private static final long serialVersionUID = 1L;
	private int numVol;
	private String destination;
	private String dateDepart;
	private int nbPlacesDispos;
	private double prix;
	
	public Vol(int numVol, String destination, String dateDepart, int nbPlacesDispos, double prix) {
		this.numVol = numVol;
		this.destination = destination;
		this.dateDepart = dateDepart;
		this.nbPlacesDispos = nbPlacesDispos;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "[numVol=" + numVol + ", destination=" + destination
				+ ", dateDepart=" + dateDepart + ", nbPlacesDispos="
				+ nbPlacesDispos + ", prix="
				+ prix + "]\n";
	}

	public int getNumVol() {
		return numVol;
	}

	public String getDestination() {
		return destination;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public int getNbPlacesDispos() {
		return nbPlacesDispos;
	}

	public double getPrix() {
		return prix;
	}

	public boolean verifPlaces(int nbPlacesSouhaitées){
		if (nbPlacesDispos - nbPlacesSouhaitées >=0){
			return true;
		}
		return false;
	}
	
	public void reserver(int nbPlacesSouhaitées){
		nbPlacesDispos -= nbPlacesSouhaitées;
	}
}
