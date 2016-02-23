package model;

import java.util.HashMap;
import java.util.Map;

public class CamionSA {

	private static Map<Integer,Avion> listCamion = new HashMap<Integer,Avion>() ;
	
	public static void createCamion (int mat, String brand, String cityLoc) {
		Avion camion = listCamion.get(mat);
		if (cityLoc == null | camion != null)
			throw new IllegalArgumentException("Ville ou camion non existant");
		camion = new Avion (mat,brand,cityLoc);
		listCamion.put(mat, camion);
		
	}
	
	public static String localiser (int mat) {
		Avion camion = listCamion.get(mat);
		if (camion == null)
			try {
				throw new Exception ("Aucun camion de cette matriculation recensé");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return camion.getLocCity();
	}
	
}
