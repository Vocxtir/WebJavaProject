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
	public static IPersistance persist;
	
	public void init(){
		try {
			persist= new PersistanceOracle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = -226096639486289909L;

	protected void doPost (HttpServletRequest request, HttpServletResponse resp) throws ServletException, java.io.IOException {
		//Identifier le service demand�
		String functionRequest = request.getParameter("controlFunction");
		
		
		if (functionRequest.equalsIgnoreCase("authentification")){
			String login 		= request.getParameter("login");
			String password		= request.getParameter("paswword");
			
			if(UserSA.authentificateUser(login, password)){
				HttpSession session = request.getSession(true);
				User u = new User(login, password);
				session.setAttribute("User", u) ;
			}
			RequestDispatcher reqDisp = request.getRequestDispatcher("/view/dispReservation.jsp");
			reqDisp.forward(request, resp);
		}
		else if (functionRequest.equalsIgnoreCase("signup")){
			String login 		= request.getParameter("login");
			String password		= request.getParameter("paswword");
			
			try {
				UserSA.createUser(login, password);
			} catch (Exception e) {e .printStackTrace();}
		}
		else if (functionRequest.equals("reserver")) {
			
			String login 		= request.getParameter("login");
			String password		= request.getParameter("password");
			String destination	= request.getParameter("destination");
			String dateDepart	= request.getParameter("date");	
			int nbPlaces = Integer.parseInt(request.getParameter("nbPlaces"));
			
			try{	//Executer le service demand�
				ReservationSA.creerReservation(new User(login, password), destination, dateDepart, nbPlaces); 
				request.setAttribute("confirmation", true);
			}
			catch (Exception e){
				request.setAttribute("Error",e); 
			}
			RequestDispatcher reqDisp = request.getRequestDispatcher("/view/dispReservation.jsp");
			reqDisp.forward(request, resp);
			
		}
		else if (functionRequest.equalsIgnoreCase("search"))
				
			try{	//Executer le service demand�
				request.setAttribute("mat",VolSA.getDestination(Integer.parseInt(request.getParameter("mat"))));
				request.setAttribute("confirmation", true);
			}
			catch (Exception e){
				request.setAttribute("Error",e); }
			
		//Mettre les r�sultats � la vue
			RequestDispatcher reqDisp = request.getRequestDispatcher("/view/dispCamion.jsp");
			reqDisp.forward(request, resp);
	
	}
	
	
}


