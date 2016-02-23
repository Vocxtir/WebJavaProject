<html>

<%@ page import="java.util.Date" %>
<% 
	 Date today = new Date(); 
	 String name = request.getParameter("name");
	 char gender = request.getParameter("gender");
	 String civil ;
	 
	 if (gender == "M")
		 civil = "Mr" ;
	 else
		 civil = "Mme" ;
 %>

	<body>


		<h1> Hellow World ! </h1>
		
		<p> Nous sommes le <%= today %> </p>  

			<h2> Bienvenue Mr.<%= name %> </h2>

			<h3> Saisie de camion <h3>
		<form action="action_page.php" method="POST">
		  Matriculation:<br>
		  <input type="text" name="matriculation" value=""><br>
		  Marque:<br>
		  <input type="text" name="marque" value=""><br><br>
		  Ville de location:<br>
		  <input type="text" name="villeLoc" value=""><br><br>
		  <input type="hidden" name="controlfunction" value=""><br><br>
		  <input type="submit" value="Submit">
	</form> 


	<body>





</html>