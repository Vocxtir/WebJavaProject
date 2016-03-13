<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<%! 		
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("User", u) ;
		
%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>B.F.C.E - Home</title>
<link href="style.css" rel="stylesheet" type="text/css" />
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
				<form action="/addFlight" method="POST">
					<fieldset>
					<legend>Register a new Flight</legend>
					<label for="flightnum">Flight Number</label>
					<input type="text" name="flightnum" value="">
					
					<label for="destination">Destination</label>
					<input type="text" name="destination" value="">
					
										
					<label for="departure">Departure</label>
					<input type="text" name="departure" value="">
					
										
					<label for="places">Places</label>
					<input type="text" name="places" value="">
					
										
					<label for="price">Price</label>
					<input type="text" name="price" value="">
					
					<input type="hidden" name="controlFunction" value="addFlight">
					
					<button type="submit" id="submit-go" class="submit">Log in</button>
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