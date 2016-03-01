<%
	Exception error = (Exception) request.getAttribute("Error");
	String mat = request.getParameter("mat");
%>
<html> <body>
	<h1> Confirmation dajout d une reservation </h1>
	<p>La reservation <%=mat%>
	<% if (error == null) {%>
	a bien &eacutet&eacute	ajout&eacute !
	<% } else { %>
	n a pu &#234tre ajout&eacute !
	<% } %>
	</p>
	<a href="../TP5-MVC/view"> Retour </a>
</body> </html>