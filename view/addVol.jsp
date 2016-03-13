<?xml version="1.0" encoding="utf-8"?>
<%@ page import="modele.User"%>

<%  
	User u  = (User) session.getAttribute("User");
	String username = u.getLogin();
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>B.F.C.E - Home</title>
<link href="./view/style.css" rel="stylesheet" type="text/css" />
<!-- <link href="./view/popup.css" rel="stylesheet" type="text/css" /> -->

</head>
<body>
<div id="container">
	<div id="header">
		<h1>Best Flight Company Ever</h1>
		<h2>You're gonna be high... in the air</h2>
	</div>
	<div id="middle">
		<div id="focus" style="padding-bottom: 65px; border">
			<div id="navigation">
				<h3>Navigation</h3>
				<ul>
					<li><a href="#" class="active">Home</a></li>
					<li><a href="#">Random useless column</a></li>
					<li><a href="#">Flat Flights List</a></li>
					<li><a href="#">Examples</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
			
			<div id="quicksearch" >
				<form action="/WebJavaSoleil/controleur" method="POST">
					<fieldset>
					<legend>Register a new Flight</legend>
					<label for="flightnum">Flight Number</label>
					<input type="text" name="numVol" value="">
					
					<label for="destination">Destination</label>
					<input type="text" name="destination" value="">
					
										
					<label for="places">Places</label>
					<input type="number" name="places" value="">
					
					<label for="price">Date</label>
					<input type="date" name="date" value="">
										
					<label for="price">Price</label>
					<input type="number" name="price" value="">
					
					<input type="hidden" name="controlFunction" value="addFlight">
					
					<button type="submit" id="submit-go" class="submit">Submit</button>
					</fieldset>
				</form>
			</div>
		</div>
		<div id="content">
			<div class="row">
				<div class="onequartercolumn">
					<h3>Client Spotlight</h3>
					<p>Blablabla. This client is a great sponsor, and our biggest owner in terms of shares !</p>
				</div>
				
				<h2> Being here means that you're an administrator </h2>
				<h3> Assuming you are : <%=username %> </h3>


			</div>
			<p class="top"><a href="#">Return to Top</a></p>
		</div>
	</div>
</div>
<div id="footer">
	<p>Copyright &copy; 2016 <a href="#">Best Flight Company Ever</a> | Design by: <a 
href="http://www.weissmike.com">Mike Weiss</a></p>
</div>
</body>


</html>