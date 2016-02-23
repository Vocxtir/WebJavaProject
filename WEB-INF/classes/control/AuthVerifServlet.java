package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class AuthVerifServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException { 
        
		/*String login		= request.getParameter("login") ;
		String password 	= request.getParameter("mdp");
		
		User u = new User (login, password);*/
		
		HttpSession session = request.getSession(true);
		User u = (User) session.getAttribute("User") ;
        
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();	//Equivalent au Syso
        out.println("<html>");
        out.println("<body bgcolor=\"white\">");
        
		if (u == null){

			
		    String title = "Résultat de la vérification : <br> Vous n'êtes pas identifié <br>";
	        out.println("<h1>" + title + "</h1>");
	        
		}
		else {

			
	        String title = "Résultat de la vérification : <br> Vous êtes identifié : <br>";

	        out.println("<html>");
	        out.println("<body bgcolor=\"white\">");

	        out.println("<h1>" + title + u.getLogin() + u.getPassword() +  "</h1>"
	        		+ "<a href=\"/dc">" Deconnection </a>"); //C'était pour tester la déconnexion

		}
		
        out.println("</body>");
        out.println("</html>");
        
     /*   response.setContentType("text/html");
        PrintWriter out = response.getWriter();	//Equivalent au Syso
		
	    String title = " On est pas supposé arrivé ici !! ";

        out.println("<html>");
        out.println("<body bgcolor=\"white\">");

        out.println("<h1>" + title + "</h1>");
        
        
        out.println("</body>");
        out.println("</html>"); */
    }
	
	
	
}
