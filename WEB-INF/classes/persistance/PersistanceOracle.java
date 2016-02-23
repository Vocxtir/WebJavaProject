package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Avion;
import model.User;

public class PersistanceOracle implements IPersistance {

	Connection connexion;
	PreparedStatement pStStockerAvion;
	PreparedStatement pAddNewUser ;
	
	public PersistanceOracle() throws Exception {
		Class.forName ("oracle.jdbc.OracleDriver");
		connexion = DriverManager.getConnection("vs-oracle", "GRP...", "GRP...");
		pStStockerAvion = connexion.prepareStatement("insert into Camions values (?, ?, ?)");
		pAddNewUser = connexion.prepareStatement("insert into USER values (?,?)");
	}
	
	@Override
	public void stockerAvion(Avion avion) throws Exception {
		pStStockerAvion.setLong (1, avion.getMat());
		pStStockerAvion.setString (2, avion.getBrand());
		pStStockerAvion.setString (3, avion.getLocCity());
		pStStockerAvion.executeUpdate();
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



}
