package control;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Avion;
import model.AvionSA;

public class AvionAddServlet extends HttpServlet {

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
	*/
	protected void doPost (HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		//Identifier le service demandé
		String functionRequest = request.getParameter("controlFunction");
		if (functionRequest.equals("addCamion")) {
			int mat			= Integer.parseInt(request.getParameter("mat")) ;
			String brand	= request.getParameter("brand");
			String cityLoc	= request.getParameter("cityLoc");	
			
			try{	//Executer le service demandé
				AvionSA.createAvion(mat,brand,cityLoc); 
				request.setAttribute("confirmation", true);
			}
			catch (Exception e){
				request.setAttribute("Error",e); }
			
			RequestDispatcher reqDisp = request.getRequestDispatcher("/view/dispCamion.jsp");
			reqDisp.forward(request, resp);
			
		}
		else if (functionRequest.equalsIgnoreCase("search"))
				
			try{	//Executer le service demandé
				request.setAttribute("mat",AvionSA.localiser(Integer.parseInt(request.getParameter("mat"))));
				request.setAttribute("confirmation", true);
			}
			catch (Exception e){
				request.setAttribute("Error",e); }
			
		//Mettre les résultats à la vue
			RequestDispatcher reqDisp = request.getRequestDispatcher("/view/dispCamion.jsp");
			reqDisp.forward(request, resp);
	
	}
	
	
}


