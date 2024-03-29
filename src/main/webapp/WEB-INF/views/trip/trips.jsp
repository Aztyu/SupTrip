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
        <li><a href="${pageContext.request.contextPath}/auth/basket"><span class="glyphicon glyphicon-shopping-cart"></span> Bag (${fn:length(sessionScope.booking)})</a></li> 
        <li><a href="${pageContext.request.contextPath}/api"><span class=" glyphicon glyphicon-question-sign"></span> Help</a></li>
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
		<h1>Here are the trips by campus name:</h1>
		<br></br>
		<p>Select the campus:</p>
		<form method="POST" action="${pageContext.request.contextPath}/auth/trips">
			<select name="campus_id"> 
				<option value="-1">-- Every campus --</option>
				<c:forEach var="campus" items="${campus_list}">
						<option value="${campus.id}"
							<c:if test="${campus.id eq campus_id}">
								selected
							</c:if>
						>${campus.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Search" />
   		</form>
			
		<c:if test="${ not empty trips }">
			<c:forEach items="${trips}" var="trip">
				<div>
					<ol class="trips">
						<li style="margin-left: 1px; margin-top: 50px;">
							<ul>
								<li>
									<h4>${ trip.description }</h4>
								</li>
								<li>
									<h5><b>FROM :</b></h5>
									<h5>${ trip.start.name }</h5>
								</li>
								<li>
									<h5><b>TO :</b></h5>
									<h5>${ trip.destination.name }</h5>
								</li>
								<li>
									<h5><b>REMAINING TIME :</b></h5>
									<h5>${ trip.remaining_time }</h5>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/auth/book/${ trip.id }">Add to bag</a>
								</li>
							</ul>  
						</li>
					</ol>
				</div>
				
			</c:forEach>
		</c:if>
		<c:if test="${ empty trips }">
			<p>${ message }</p>
		</c:if>
		
		</div>
	</body>
</html>