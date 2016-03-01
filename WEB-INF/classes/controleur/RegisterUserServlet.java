package controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistance.IPersistance;
import persistance.PersistanceOracle;
import modele.User;
import modele.UserSA;



public class RegisterUserServlet extends HttpServlet {

	private static final long serialVersionUID = -6562063338129275392L;

	public static IPersistance persist;
	
	public void init(){
		try {
			persist= new PersistanceOracle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
		
		String login		= request.getParameter("login") ;
		String password 	= request.getParameter("password");
		
		UserSA.createUser(login, password);
		
    }

	
	//Hello Git
}

