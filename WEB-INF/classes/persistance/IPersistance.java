package persistance;

import model.Avion;


public interface IPersistance {
	public void stockerCamion (Avion camion) throws Exception;
	public Avion trouverCamion (String immat);
}
