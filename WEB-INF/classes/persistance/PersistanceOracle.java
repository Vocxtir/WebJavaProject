package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Avion;
import model.Reservation;
import model.User;

public class PersistanceOracle implements IPersistance {

	Connection connexion;
	PreparedStatement pAddVol;
	PreparedStatement pAddReservation ;
	PreparedStatement pAddNewUser ;
	
	public PersistanceOracle() throws Exception {
		Class.forName ("oracle.jdbc.OracleDriver");
		connexion = DriverManager.getConnection("vs-oracle", "GRP...", "GRP...");
		pAddVol = connexion.prepareStatement("insert into Camions values (?, ?, ?)");
		pAddNewUser = connexion.prepareStatement("insert into USER values (?,?)");
	}
	
	@Override
	public void addAvion(Avion avion) throws Exception {
		pAddVol.setLong (1, avion.getMat());
		pAddVol.setString (2, avion.getBrand());
		pAddVol.setString (3, avion.getLocCity());
		pAddVol.executeUpdate();
	}
	
	

	@Override
	public Avion trouverQvion(String immat) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void addUser(User user) throws Exception {
		pAddNewUser.setString(1, user.getLogin());
		pAddNewUser.setString(2, user.getPassword());
		
	}

	public void addReservation (Reservation reservation){
		
	}

}
