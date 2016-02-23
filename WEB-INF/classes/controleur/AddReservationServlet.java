package controleur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.User;
import modele.VolSA;

public class AddReservationServlet extends HttpServlet {


	private static final long serialVersionUID = -226096639486289909L;
	{
	/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException { 
		
		String functionRequest = request.getParameter("function");
		if (functionRequest.equals("addCamion")) {
			int mat			= Integer.parseInt(request.getParameter("mat")) ;
			String brand	= request.getParameter("brand");
			String townLoc	= request.getParameter("townLoc");	
			
			try{
				CamionSA.createCamion(mat,brand,townLoc); 
				request.setAttribute("confirmation", true);
			}
			catch (Exception e){
				request.setAttribute("Error",e); }
			
			RequestDispatcher reqDisp = request.getRequestDispatcher("/view/dispCamion.jsp");
			
		}
		else if (functionRequest.equalsIgnoreCase("search"))
				CamionSA.localiser(Integer.parseInt(request.getParameter("mat")));
	
	}
		
	}
	*/}
	protected void doPost (HttpServletRequest request, HttpServletResponse resp) throws ServletException, java.io.IOException {
		//Identifier le service demand�
		String functionRequest = request.getParameter("controlFunction");
		if (functionRequest.equals("reserver")) {
			String login = request.getParameter("login");
			String password = request.getParameter("paswword");
			String destination	= request.getParameter("destination");
			String dateDepart	= request.getParameter("date");	
			int nbPlaces = Integer.parseInt(request.getParameter("nbPlaces"));
			
			try{	//Executer le service demand�
				VolSA.creerReservation(new User(login, password), destination, dateDepart, nbPlaces); 
				request.setAttribute("confirmation", true);
			}
			catch (Exception e){
				request.setAttribute("Error",e); 
			}
			RequestDispatcher reqDisp = request.getRequestDispatcher("/view/dispCamion.jsp");
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


