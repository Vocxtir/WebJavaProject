<html>
<!-- //catalogue.JSP?action={consulter|ajouter}&product={nom_du_produit} -->
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Array List" %>
<%!
	
	List<String> list = new ArrayList<String>() ;
	%>
<%	
	String action = request.getParameter("action");
	String product = request.getParameter("product");
	
	String result = null ;
	
	if (action.equals("consulter")){
		for (String i : list)
			result += i + "\n" ;
	}
	else if (action.equals("ajouter"))
		list.add(product) ;
		
	 
 %>

	<body>


		<h1> Hellow World ! </h1>
		


			<h2>  <%= result %> </h2>



	<body>





</html>