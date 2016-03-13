package controleur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.ReservationSA;
import modele.User;
import modele.UserSA;
import modele.VolSA;
import persistance.IPersistance;
import persistance.PersistanceOracle;

public class ControlServlet extends HttpServlet {

	private static final long serialVersionUID = -226096639486289909L;

	public static IPersistance persist = new PersistanceOracle();
	Authentification auth = new Authentification();

	protected void doPost (HttpServletRequest request, HttpServletResponse resp) throws ServletException, java.io.IOException {
		
		//Identifier le service demand�
		String login		= request.getParameter("login") ;
		String password 	= request.getParameter("password");
		String name			= request.getParameter("name");
		String lastname		= request.getParameter("lastname");
		User u = new User (login, password, name, lastname);
		
		HttpSession session = request.getSession(true);
		
		if (request.getParameter("controlFunction").equalsIgnoreCase("signIn")){
			if (auth.signIn(u)) session.setAttribute("User", u);
			else auth.signUp(u); //go sur la page de creation de compte
		}
		if (request.getParameter("controlFunction").equalsIgnoreCase("signup")){
			if (auth.signUp(u)) session.setAttribute("User", u);
			else auth.signUp(u); //relancer la page de cr�ation
		}
		else if (request.getParameter("controlFunction").equals("reserver")) {
			String destination	= request.getParameter("destination");
			String dateDepart	= request.getParameter("date");	
			int nbPlaces = Integer.parseInt(request.getParameter("nbPlaces"));
			try{	//Executer le service demand�
				ReservationSA.creerReservation(u, destination, dateDepart, nbPlaces); 
				request.setAttribute("confirmation", true);
			}
			catch (Exception e){
				request.setAttribute("Error",e); 
			}
			RequestDispatcher reqDisp = request.getRequestDispatcher("/view/dispReservation.jsp");
			reqDisp.forward(request, resp);

		}
		else if (request.getParameter("controlFunction").equalsIgnoreCase("search"))
			try{	//Executer le service demand�
				request.setAttribute("mat",VolSA.getDestination(Integer.parseInt(request.getParameter("mat"))));
				request.setAttribute("confirmation", true);
			}
		catch (Exception e){
			request.setAttribute("Error",e); 
		}
		//Mettre les r�sultats � la vue
		RequestDispatcher reqDisp = request.getRequestDispatcher("/view/dispCamion.jsp");
		reqDisp.forward(request, resp);

	}


}


