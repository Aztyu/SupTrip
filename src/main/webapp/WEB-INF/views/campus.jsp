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
        
        <li><a href="${pageContext.request.contextPath}/home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
        <li><a href="${pageContext.request.contextPath}/trips"><span class="glyphicon glyphicon-plane"></span> See trips</a></li> 
        <li><a href="${pageContext.request.contextPath}/create/trip"><span class="glyphicon glyphicon-globe"></span> Create a new trip</a></li>
        <li><a href="${pageContext.request.contextPath}/campus"><span class="glyphicon glyphicon-education"></span> Create new campus</a></li>
        <li><a href="${pageContext.request.contextPath}/logout"><span class=" glyphicon glyphicon-log-out"></span> Logout</a></li> 
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> ${sessionScope.user.firstname} ${sessionScope.user.lastname}</a></li>
        </ul>
    </div>
  </div>

</nav>
<div class="formu">
	<form method="POST" action="${pageContext.request.contextPath}/campus">
        <p>Campus name :</p>
        <input type="text" name="name">
        
        <p>Address :</p>
        <input type="text" name="address">
        
        <p>City :</p>
        <input type="text" name="city">
        
        <p>Postal code:</p>
        <input type="text" name="postal_code">
        
        <input type="submit" value="Create campus" />
    </form>
</div>
</body>
</html>