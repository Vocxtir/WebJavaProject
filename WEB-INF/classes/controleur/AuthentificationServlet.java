package controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import persistance.IPersistance;
import persistance.PersistanceOracle;
import modele.User;

/**
 * 
 * @author Vocxtir
 *ON NE S'EN SERVIRA PAS
 */


public class AuthentificationServlet extends HttpServlet {

	private static final long serialVersionUID = -6562063338129275392L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
		
		String login		= request.getParameter("login") ;
		String password 	= request.getParameter("password");
		String name			= request.getParameter("name");
		String lastname		= request.getParameter("lastname");
		User u = new User (login, password, name, lastname);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("User", u) ;
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();	//Equivalent au Syso
		
	    String title = "Vous êtes connecté sous le nom ";

        out.println("<html>");
        out.println("<body bgcolor=\"white\">");

        out.println("<h1>" + title + u.getLogin() + "</h1>");
        
        
        out.println("</body>");
        out.println("</html>");
    }

	
	//Hello Git
}

