<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>
			Hello world!  
		</h1>
		<a href="${pageContext.request.contextPath}/register">Register</a>
		
		<h2>  This is the home of SUPINFO own trip website ! </h2>
		
		<p>There are currently ${ users } users and ${ trips } trips organized. Welcome aboard !!</p>
	
		
	
		<form method="POST" action="${pageContext.request.contextPath}/loginRequest">
	        <p>ID Booster :</p>
	        <input type="text" name="id">
	        
	        <p>Password :</p>
	        <input type="password" name="password">
	        
	        <input type="submit" value="Connect" />
	    </form>
	    
		<c:if test="${not empty message}">
			<p style="color:red">${message}</p>
		</c:if>
	</body>
</html>
