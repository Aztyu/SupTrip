<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${sessionScope.user.firstname} ${sessionScope.user.lastname}</title>
		<link rel="icon" href="http://www.campus-booster.net/actorpictures/${sessionScope.user.booster_id}.jpg" type="image/x-icon">
		<!-- CSS -->
		<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  		
  
	</head>
	<body>
	
		
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/home">SupTrip</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        
        <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/trips">See trips</a></li> 
        <li><a href="${pageContext.request.contextPath}/create/trip">Create a new trip</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li> 
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Nom/Photo</a></li>
        </ul>
    </div>
  </div>
</nav>
	
		<br></br>
		<h2>Welcome ${sessionScope.user.firstname} ${sessionScope.user.lastname}</h2>
		
		<img src="http://www.campus-booster.net/actorpictures/${sessionScope.user.booster_id}.jpg" >
		<p>J'aime la bite</p>
	</body>
</html>