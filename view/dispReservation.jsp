<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Array List" %>

<%
	Exception error = (Exception) request.getAttribute("Error");
	String mat = request.getParameter("mat");
	
	List<Reservation> reservationUser = request.getParameter("listReserv"); <!-- return ArrayList<Resrvation> -->

	
	String htmlContent ;
	
	for (Reservation r : reservationUser){
		htmlContent +=	<tr>
							<td>r.getID()</td> <!-- numéro de réservation -->
							<td>r.getDestination()</td>
							<td>r.getNbPlaces()</td>
							<td>r.getConfirm()</td> <!-- Si en attente ou définitif -->
						</tr>
	}
	
%>


<html> <body>
	<h1> Voici la liste de vos réservations</h1>
 <table style="width:100%">

	<%= htmlContent %>
	
</table>
	
	<a href="../index.html"> Retour </a>
</body> </html>