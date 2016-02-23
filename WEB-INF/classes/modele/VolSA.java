package modele;

public class VolSA {

	public static void createVol (int numVol, String destination, String dateDepart, int nbPlacesDispos, double prix) {
		Vol vol = controleur.AuthentificationServlet.persist.trouverVol(numVol);
		if (vol != null)
			throw new IllegalArgumentException("Ville ou camion non existant");
		vol = new Vol (numVol, destination, dateDepart, nbPlacesDispos, prix);
		controleur.AuthentificationServlet.persist.addVol(vol);

	}

	public static String getDestination(int numVol) {
		Vol vol = controleur.AuthentificationServlet.persist.trouverVol(numVol);
		if (vol == null)
			try {
				throw new Exception ("Aucun vol de ce num�ro de vol enregistr�");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vol.getDestination();
	}

	public static void creerReservation(User client, String destination, String dateDepart, int nbPlacesSouhait�es){
		controleur.AuthentificationServlet.persist.addReservation(new Reservation(client, destination, dateDepart, nbPlacesSouhait�es));
	}
}
