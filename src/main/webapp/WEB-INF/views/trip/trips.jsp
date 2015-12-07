<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
		
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<title>Insert title here</title>
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
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        </ul>
    </div>
  </div>
</nav>
		
		<p>Here are the trips</p>
	
	<c:forEach items="${trips}" var="trip">
		<div>
			<h1>${ trip.description }</h1>
		</div>
	</c:forEach>
</body>
</html>