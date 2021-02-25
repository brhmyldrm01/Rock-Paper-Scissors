<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link href="<c:url value="/resources/styleResult.css" />" rel="stylesheet">
</head>

<body>
<header>

	${result}	

</header>


<form action="rps" method="GET" id="buton" >
<button type="submit" id="again"> <p>	Try Again </p> </button>
</form>
	
	
</body>
