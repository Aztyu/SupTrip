<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<%@ include file="/WEB-INF/views/include/favicon.jsp" %>
		<title>See Trips</title>
	</head>

<title>See Trips</title>
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
        <li><a href="${pageContext.request.contextPath}/auth/basket"><span class=" glyphicon glyphicon-log-out"></span> Basket</a></li> 
        <li><a href="${pageContext.request.contextPath}/logout"><span class=" glyphicon glyphicon-log-out"></span> Logout</a></li> 
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="toto">
        <a href="${pageContext.request.contextPath}/auth/home">
        	<img class="id_img" src="http://www.campus-booster.net/actorpictures/${sessionScope.user.booster_id}.jpg" />
        	</span> ${sessionScope.user.firstname} ${sessionScope.user.lastname} 
        </a>
        </li>
        </ul>
    </div>
  </div>

</nav>
<div class="formu">		
		<h1>Trips in basket:</h1>
		<c:forEach items="${booking}" var="book" varStatus="loop">
			<div>
				<!-- Afficher les booking en cours sous forme de tableaux -->
				<p>${ book.trip_booked.description }</p>
			</div>
			<a href="${pageContext.request.contextPath}/auth/book/confirm/${loop.index}">Confirm</a>
			<a href="${pageContext.request.contextPath}/auth/book/delete/${loop.index}">Delete</a>
		</c:forEach>
		
		<h1>Trips already booked:</h1>
		<c:forEach items="${booked_trips}" var="trip">
			<div>
				<p>${ trip.trip_booked.description }</p>
			</div>
		</c:forEach>
		
		</div>
	</body>
</html>