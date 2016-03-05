package modele;

import controleur.ControlServlet; 

public class VolSA {

	public static void createVol (int numVol, String destination, String dateDepart, int nbPlacesDispos, double prix) throws Exception {
		Vol vol = ControlServlet.persist.trouverVol(numVol);
		if (vol != null)
			throw new IllegalArgumentException("Ville ou camion non existant");
		vol = new Vol (numVol, destination, dateDepart, nbPlacesDispos, prix);
		ControlServlet.persist.addVol(vol);

	}

	public static String getDestination(int numVol) throws Exception {
		Vol vol = ControlServlet.persist.trouverVol(numVol);
		if (vol == null)
			try {
				throw new Exception ("Aucun vol de ce numéro de vol enregistré");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vol.getDestination();
	}


}
