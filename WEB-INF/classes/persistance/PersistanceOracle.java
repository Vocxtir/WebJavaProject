package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modele.Reservation;
import modele.User;
import modele.Vol;

public class PersistanceOracle implements IPersistance {
	//Oracle
	//public static String _url="jdbc:oracle:thin:@vs-oracle:1521:ORCL", _user = "GRP204US11", _password = "GRP204US11" ;		
	//chez François
	public static String _url="jdbc:oracle:thin:@localhost:1521/xe", _user = "webJava", _password = "webJava" ;
	//MySQL
	//public static String _url="jdbc:mysql://localhost:8080/TousAuSoleil" , _user = "root" , _password = "" ;	
	Connection connexion;

	PreparedStatement pAddVol;

	PreparedStatement pAddReservation;

	PreparedStatement pAddNewUser ;
	PreparedStatement pCheckUser ;
	PreparedStatement pFindUserByLogin ;

	public PersistanceOracle(){
		try {
			Class.forName ("oracle.jdbc.OracleDriver");
			//Class.forName ("com.mysql.jdbc.Driver");

			connexion = DriverManager.getConnection(_url, _user, _password);
			
			pAddVol = connexion.prepareStatement("insert into VOL values (?, ?, ?)");
			
			pAddReservation = connexion.prepareStatement("insert into RESERVATIONS values (?, ?, ?, ?)");
			
			pAddNewUser = connexion.prepareStatement("insert into USER values (?,?,?,?,?)");
			pCheckUser = connexion.prepareStatement("select * from USER where Login = ? and mdp = ?");
			pFindUserByLogin = connexion.prepareStatement("select * from USER where Login = ?");
		} catch (ClassNotFoundException | SQLException e) {
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
			e.printStackTrace();
		}
	}
	@Override
	public Vol trouverVol(int numVol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUser (User u){
		try {
			pCheckUser.setString(1, u.getLogin());
			pCheckUser.setString(2, u.getPassword());
			return pCheckUser.executeQuery().next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void addUser(User user){
		try {
			pAddNewUser.setString(1, user.getLogin());
			pAddNewUser.setString(2, user.getPassword());
			pAddNewUser.setString(3, user.getName());
			pAddNewUser.setString(4, user.getLastname());
			pAddNewUser.setString(5, user.getRole());
			pAddNewUser.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findUserByLogin (String login){
		try {
			pFindUserByLogin.setString(1, login);
			ResultSet resultat = pFindUserByLogin.executeQuery();
			String log = resultat.getString(1);
			String passw = resultat.getString(2);
			String name = resultat.getString(3);
			String lastname = resultat.getString(4);
			String role = resultat.getString(5);
			return new User(log, passw, name, lastname, role);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public void addReservation(Reservation resa){
		try{
			pAddReservation.setString(1, resa.getClient().getLogin());
			pAddReservation.setString (2, resa.getDestination());
			pAddReservation.setString (3, resa.getDateDepart());
			pAddReservation.setInt (4, resa.getNbPlaces());
			pAddReservation.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
