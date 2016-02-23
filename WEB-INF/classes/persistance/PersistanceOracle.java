package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Avion;

public class PersistanceOracle implements IPersistance {

	Connection connexion;
	PreparedStatement pStStockerCamion;
	
	public PersistanceOracle() throws Exception {
		Class.forName ("oracle.jdbc.OracleDriver");
		connexion = DriverManager.getConnection("vs-oracle", "GRP...", "GRP...");
		pStStockerCamion = connexion.prepareStatement("insert into Camions values (?, ?, ?)");
	}
	
	@Override
	public void stockerCamion(Avion camion) throws Exception {
		pStStockerCamion.setLong (1, camion.getMat());
		pStStockerCamion.setString (2, camion.getBrand());
		pStStockerCamion.setString (3, camion.getLocCity());
		pStStockerCamion.executeUpdate();
	}

	@Override
	public Avion trouverCamion(String immat) {
		// TODO Auto-generated method stub
		return null;
	}



}
