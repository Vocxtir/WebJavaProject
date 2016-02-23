package model;

public class VolSA {

	public static void createVol (int numVol, String destination, String dateDepart, int nbPlacesDispos, double prix) {
		Vol vol = control.AuthentificationServlet.persist.trouverVol(numVol);
		if (vol != null)
			throw new IllegalArgumentException("Ville ou camion non existant");
		vol = new Vol (numVol, destination, dateDepart, nbPlacesDispos, prix);
		control.AuthentificationServlet.persist.addVol(numVol, vol);

	}

	public static String getDestination(int numVol) {
		Vol vol = control.AuthentificationServlet.persist.trouverVol(numVol);
		if (vol == null)
			try {
				throw new Exception ("Aucun camion de cette matriculation recensé");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vol.getDestination();
	}

	public static void createReservation(User client, String destination, String dateDepart, int nbPlacesSouhaitées){

	}
}
