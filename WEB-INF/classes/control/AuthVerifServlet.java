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

			
		    String title = "R�sultat de la v�rification : <br> Vous n'�tes pas identifi� <br>";
	        out.println("<h1>" + title + "</h1>");
	        
		}
		else {

			
	        String title = "R�sultat de la v�rification : <br> Vous �tes identifi� : <br>";

	        out.println("<html>");
	        out.println("<body bgcolor=\"white\">");

	        out.println("<h1>" + title + u.getLogin() + u.getPassword() +  "</h1>"
	        		+ "<a href=\"/dc">" Deconnection </a>"); //C'�tait pour tester la d�connexion

		}
		
        out.println("</body>");
        out.println("</html>");
        
     /*   response.setContentType("text/html");
        PrintWriter out = response.getWriter();	//Equivalent au Syso
		
	    String title = " On est pas suppos� arriv� ici !! ";

        out.println("<html>");
        out.println("<body bgcolor=\"white\">");

        out.println("<h1>" + title + "</h1>");
        
        
        out.println("</body>");
        out.println("</html>"); */
    }
	
	
	
}
