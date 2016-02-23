package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DisconnectServlet extends HttpServlet {

	private static final long serialVersionUID = -7736247186414685664L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException { 

		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();	//Equivalent au Syso
		
	    String title = " Vous êtes desormais déconnecté ";

        out.println("<html>");
        out.println("<body bgcolor=\"white\">");

        out.println("<h1>" + title + "</h1>");
        
        
        out.println("</body>");
        out.println("</html>"); 
		
		HttpSession session = request.getSession(true);
		
		session.invalidate();
	
	}
}
