<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home</title>
		<link rel="icon" href="http://www.campus-booster.net/actorpictures/${sessionScope.user.booster_id}.jpg" type="image/x-icon">
		
	</head>
	<body>
		<a href="${pageContext.request.contextPath}/auth/trips">See trips</a>
		<a href="${pageContext.request.contextPath}/auth/create/trip">Create a new trip</a>
		<a href="${pageContext.request.contextPath}/auth/logout">Logout</a>
		
		<h2>Welcome ${sessionScope.user.firstname} ${sessionScope.user.lastname}</h2>
		<p></p>
	</body>
</html>