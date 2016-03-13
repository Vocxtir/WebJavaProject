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
import modele.Vol;
import modele.VolSA;
import persistance.IPersistance;
import persistance.PersistanceOracle;

public class ControlServlet extends HttpServlet {

	private static final long serialVersionUID = -226096639486289909L;

	public static IPersistance persist = new PersistanceOracle();
	CAuthentification auth = new CAuthentification();

	protected void doPost (HttpServletRequest request, HttpServletResponse resp) throws ServletException, java.io.IOException {

		//Identifier le service demandé
		String login		= request.getParameter("login") ;
		String password 	= request.getParameter("password");
		String name			= request.getParameter("name");
		String lastname		= request.getParameter("lastname");
		User u = new User (login, password, name, lastname);

		HttpSession session = request.getSession(true);
		RequestDispatcher reqDisp = null;

		if (request.getParameter("controlFunction").equalsIgnoreCase("signIn")){
			if (auth.signIn(u)){
				u = auth.getUser(u);
				session.setAttribute("User", u);
				if (u.getRole().equals("Administrateur")){
					reqDisp = request.getRequestDispatcher("/view/addVol.jsp");
				}
				else {
					reqDisp = request.getRequestDispatcher("/view/reservation.html");
				}
				reqDisp.forward(request, resp);
			}
			else {
				reqDisp = request.getRequestDispatcher("index.html");
				reqDisp.forward(request, resp);
			}
		}

		if (request.getParameter("controlFunction").equalsIgnoreCase("signup")){
			if (auth.signUp(u)) {
				u = auth.getUser(u);
				session.setAttribute("User", u);
				if (u.getRole().equals("Administrateur")){
					//RequestDispatcher reqDisp = request.getRequestDispatcher("/view/reservation.html");
				}
				else {
					reqDisp = request.getRequestDispatcher("/view/reservation.html");
				}
				reqDisp.forward(request, resp);
			}
			else {
				reqDisp = request.getRequestDispatcher("index.html");
				reqDisp.forward(request, resp);
			}
		}
		
		if (request.getParameter("controlFunction").equalsIgnoreCase("addFlight")){
			int numVol 			= Integer.parseInt(request.getParameter("numVol")) ;
			String destination 	= request.getParameter("destination");
			String date			= request.getParameter("dates");
			int places			= Integer.parseInt(request.getParameter("places"));
			double price		= Integer.parseInt(request.getParameter("price"));
			persist.addVol(new Vol(numVol, destination, date, places, price));
			reqDisp = request.getRequestDispatcher("/view/addVol.jsp");
			reqDisp.forward(request, resp);
		}
		
	}


}


