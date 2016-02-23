package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;



public class AuthVerifServlet extends HttpServlet {

	private static final long serialVersionUID = -2019466735636484486L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
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
					+ "<a href=> Deconnection </a>");
			//C'était pour tester la déconnexion masi le /dc ne fonctionne pas, si on peut régler ça	}

			out.println("</body>");
			out.println("</html>");
		}
	}
}
