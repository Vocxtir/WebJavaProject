package model;

import java.util.HashMap;
import java.util.Map;

public class AvionSA {

	private static Map<Integer,Avion> listAvion = new HashMap<Integer,Avion>() ;
	
	public static void createAvion (int mat, String brand, String cityLoc) {
		Avion camion = listAvion.get(mat);
		if (cityLoc == null | camion != null)
			throw new IllegalArgumentException("Ville ou camion non existant");
		camion = new Avion (mat,brand,cityLoc);
		listAvion.put(mat, camion);
		
	}
	
	public static String localiser (int mat) {
		Avion camion = listAvion.get(mat);
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
