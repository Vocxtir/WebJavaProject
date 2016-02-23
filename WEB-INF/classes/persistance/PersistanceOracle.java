package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import modele.Reservation;
import modele.User;
import modele.Vol;

public class PersistanceOracle implements IPersistance {

	Connection connexion;
	PreparedStatement pStStockerVol;
	PreparedStatement pAddNewUser ;
	
	public PersistanceOracle() throws Exception {
		Class.forName ("oracle.jdbc.OracleDriver");
		connexion = DriverManager.getConnection("vs-oracle", "GRP...", "GRP...");
		pStStockerVol = connexion.prepareStatement("insert into Camions values (?, ?, ?)");
		pAddNewUser = connexion.prepareStatement("insert into USER values (?,?)");
	}
	
	@Override
	public void stockerVol(Vol vol) throws Exception {
		pStStockerVol.setInt (1, vol.getNumVol());
		pStStockerVol.setString (2, vol.getDestination());
		pStStockerVol.setString (3, vol.getDateDepart());
		pStStockerVol.setInt (4, vol.getNbPlacesDispos());
		pStStockerVol.setDouble (5, vol.getPrix());
		pStStockerVol.executeUpdate();
	}
	

	@Override
	public void addUser(User user) throws Exception {
		pAddNewUser.setString(1, user.getLogin());
		pAddNewUser.setString(2, user.getPassword());
	}

	@Override
	public Vol trouverVol(int numVol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addVol(Vol vol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReservation(Reservation v) {
		// TODO Auto-generated method stub
		
	}
}
