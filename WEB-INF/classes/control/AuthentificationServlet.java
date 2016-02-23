package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;



public class AuthentificationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException { 
        
		String login		= request.getParameter("login") ;
		String password 	= request.getParameter("password");
		
		User u = new User (login, password);
		
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

}

