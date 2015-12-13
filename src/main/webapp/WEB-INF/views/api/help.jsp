<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<%@ include file="/WEB-INF/views/include/favicon.jsp" %>
<title>Help</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="${pageContext.request.contextPath}/auth/home">SupTrip</a>
		    </div>
		    <div>
		      <ul class="nav navbar-nav">
		        
		        <li><a href="${pageContext.request.contextPath}/auth/home"><span class="glyphicon glyphicon-home"></span> Home/Profile</a></li>
		        <li><a href="${pageContext.request.contextPath}/auth/trips"><span class="glyphicon glyphicon-plane"></span> See trips</a></li> 
		        <li><a href="${pageContext.request.contextPath}/auth/create/trip"><span class="glyphicon glyphicon-globe"></span> Create a new trip</a></li>
		        <li><a href="${pageContext.request.contextPath}/auth/campus"><span class="glyphicon glyphicon-education"></span> Create new campus</a></li>
		        <li><a href="${pageContext.request.contextPath}/auth/basket"><span class="glyphicon glyphicon-shopping-cart"></span> Bag (${fn:length(sessionScope.booking)})</a></li> 
		        <li><a href="${pageContext.request.contextPath}/api"><span class=" glyphicon glyphicon-question-sign"></span> Help</a></li>
		        <li><a href="${pageContext.request.contextPath}/logout"><span class=" glyphicon glyphicon-log-out"></span> Logout</a></li> 
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li class="toto">
		        <a href="">
		        	<img class="id_img" src="http://www.campus-booster.net/actorpictures/${sessionScope.user.booster_id}.jpg" />
		        	</span> ${sessionScope.user.firstname} ${sessionScope.user.lastname} 
		        </a>
		        </li>
		        </ul>
		    </div>
		  </div>
		
		</nav>
	
	<div class = formu>
	<h1>API user guide</h1>
	<br></br>
	<h2>List of all trips :</h2>	
	<p>Returns a list of all the trips</p>
	<a href="${pageContext.request.contextPath}/api/trips" class="btn btn-primary">All trips</a>
	
	<h2>List of all campuses :</h2>
	<p>Returns a list of all the existing campuses</p>
	<a href="${pageContext.request.contextPath}/api/campuses" class="btn btn-primary">All campuses</a>
	
	<h2>List trip by campus :</h2>
	<p>Returns a list of all the trips from or to a campus, pass the campus id in the url</p>
	<a href="${pageContext.request.contextPath}/api/trips/1" class="btn btn-primary">All trips by existing campuses</a>
	</div>
</body>
</html>