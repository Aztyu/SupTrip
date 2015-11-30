<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Trip creation</title>
	</head>
	<body>
		<form method="POST" action="${pageContext.request.contextPath}/create/tripRequest">
        <p>Description:</p>
        <input type="text" name="description">
        
        <p>Departure:</p>
        <select name="campus_start"> 
			<c:forEach var="campus" items="${campus_list}">
				<option value="${campus.id}">${campus.name}</option>
			</c:forEach>
		</select> 
		
		<p>Arrival:</p>
        <select name="campus_end"> 
			<c:forEach var="campus" items="${campus_list}">
				<option value="${campus.id}">${campus.name}</option>
			</c:forEach>
		</select> 
     
        <input type="submit" value="S'inscrire" />
    </form>
	</body>
</html>