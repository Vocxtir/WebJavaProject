<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Array List" %>

<%
	Exception error = (Exception) request.getAttribute("Error");
	HttpSession session = request.getSession(true);
	
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


<html>
<link href="style.css" rel="stylesheet" type="text/css" /> <body>

	<div id="middle">
		<div id="quicksearch">
	<h1> Voici la liste de vos réservations</h1>
 <table style="width:100%">

	<%= htmlContent %>
	
</table>
	</div>
	<a href="../index.html"> Retour </a>
	
	</div>
</body> </html>