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
	PreparedStatement pAddVol;
	PreparedStatement pAddNewUser ;
	PreparedStatement pAddReservation;

	public PersistanceOracle(){
		try {
			Class.forName ("oracle.jdbc.OracleDriver");
		connexion = DriverManager.getConnection("vs-oracle", "GRP...", "GRP...");
		pAddVol = connexion.prepareStatement("insert into vol values (?, ?, ?)");
		pAddNewUser = connexion.prepareStatement("insert into USER values (?,?)");
		pAddReservation = connexion.prepareStatement("insert into reservations values (?, ?, ?)");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	@Override
	public void addVol(Vol vol){
		try {
			pAddVol.setInt (1, vol.getNumVol());
			pAddVol.setString (2, vol.getDestination());
			pAddVol.setString (3, vol.getDateDepart());
			pAddVol.setInt (4, vol.getNbPlacesDispos());
			pAddVol.setDouble (5, vol.getPrix());
			pAddVol.executeUpdate();
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
			pAddReservation.setString(1, resa.getClient().getLogin());
			pAddReservation.setString(2, resa.getClient().getPassword());
			pAddReservation.setString (3, resa.getDestination());
			pAddReservation.setString (4, resa.getDateDepart());
			pAddReservation.setInt (5, resa.getNbPlaces());
			pAddReservation.executeUpdate();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
