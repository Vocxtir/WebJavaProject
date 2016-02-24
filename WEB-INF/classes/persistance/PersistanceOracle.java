package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Reservation;
import modele.User;
import modele.Vol;

public class PersistanceOracle implements IPersistance {

	Connection connexion;
	PreparedStatement pStStockerVol;
	PreparedStatement pAddNewUser ;
	PreparedStatement pStStockerReservation;

	public PersistanceOracle(){
		try {
			Class.forName ("oracle.jdbc.OracleDriver");
		connexion = DriverManager.getConnection("vs-oracle", "GRP...", "GRP...");
		pStStockerVol = connexion.prepareStatement("insert into vol values (?, ?, ?)");
		pAddNewUser = connexion.prepareStatement("insert into USER values (?,?)");
		pStStockerReservation = connexion.prepareStatement("insert into vol values (?, ?, ?)");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	@Override
	public void addVol(Vol vol){
		try {
			pStStockerVol.setInt (1, vol.getNumVol());
			pStStockerVol.setString (2, vol.getDestination());
			pStStockerVol.setString (3, vol.getDateDepart());
			pStStockerVol.setInt (4, vol.getNbPlacesDispos());
			pStStockerVol.setDouble (5, vol.getPrix());
			pStStockerVol.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void addUser(User user){
		try {
			pAddNewUser.setString(1, user.getLogin());
			pAddNewUser.setString(2, user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Vol trouverVol(int numVol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReservation(Reservation resa){
		try{
			pStStockerReservation.setString(1, resa.getClient().getLogin());
			pStStockerReservation.setString(2, resa.getClient().getPassword());
			pStStockerReservation.setString (3, resa.getDestination());
			pStStockerReservation.setString (4, resa.getDateDepart());
			pStStockerReservation.setInt (5, resa.getNbPlaces());
			pStStockerReservation.executeUpdate();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void stockerVol(Vol vol){
		// TODO Auto-generated method stub
		
	}
}
