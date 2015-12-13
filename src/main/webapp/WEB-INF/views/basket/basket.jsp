<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
		
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<%@ include file="/WEB-INF/views/include/favicon.jsp" %>
		<link href="<c:url value="/resources/css/basket.css"/>" rel="stylesheet">
		<title>Bag</title>
	</head>

<title>Bag</title>
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

	<div class="bag">			
		<h1>Trips in bag :</h1>
		<table style="width:100%">
		  <tr>
		    <th>Description</th>
		    <th>Departure</th>		
		    <th>Start campus</th>
		    <th>Destination campus</th>
		    <th>Action</th>
		  </tr>
		  
		
			<c:forEach items="${booking}" var="book" varStatus="loop">
				<tr>
				    <td>${ book.trip_booked.description }</td>
				    <td>${ book.trip_booked.getDepartureDate() }</td>		
				    <td>${ book.trip_booked.start.name }</td>
				    <td>${ book.trip_booked.destination.name }</td>		
				    <td>
				    	<a href="${pageContext.request.contextPath}/auth/book/confirm/${loop.index}" class="btn btn-success">Confirm</a>
						<a href="${pageContext.request.contextPath}/auth/book/delete/${loop.index} " class="btn btn-danger ">Delete</a>
					</td>
				</tr>	
			</c:forEach>
		</table>
		
		<br></br>
		<h1>Trips already booked :</h1>
		
		<table style="width:100%">
		  <tr>
		    <th>Description</th>
		    <th>Departure</th>		
		    <th>Start campus</th>
		    <th>Destination campus</th>
		  </tr>
		<c:forEach items="${booked_trips}" var="trip">
			<tr>
			    <td>${ trip.trip_booked.description }</td>
			    <td>${ trip.trip_booked.getDepartureDate() }</td>		
			    <td>${ trip.trip_booked.start.name }</td>
			    <td>${ trip.trip_booked.destination.name }</td>		
			</tr>
		</c:forEach>
		</table>
	</div>	

	</body>
</html>