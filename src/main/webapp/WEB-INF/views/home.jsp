<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${sessionScope.user.firstname} ${sessionScope.user.lastname}</title>
		<%@ include file="/WEB-INF/views/include/favicon.jsp" %>
		<!-- CSS -->
		<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  		
  
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
		<div class="formu">
			<h2>Welcome ${sessionScope.user.firstname} ${sessionScope.user.lastname}</h2>
			
			<img src="http://www.campus-booster.net/actorpictures/${sessionScope.user.booster_id}.jpg" class = imageprof>
			
			<br></br>
			<div class=info>
			<p>Here is your profile, you can access your<br> 
			informations or change them if you want.</p>	
			</div>
			
			<p>Your ID Booster: ${sessionScope.user.booster_id}</p>
			
			
		</div>
		
		<div class = "modify">
		<h3>Modify profile</h3>
		
		<form method="POST" action="${pageContext.request.contextPath}/auth/home">
	        
	        
	        <p>Firstname:</p>
	        <input type="text" name="firstname"
				value="${sessionScope.user.firstname}"
	        >
	        <br></br>
	        <p>Lastname:</p>
	        <input type="text" name="lastname"
	        	value="${sessionScope.user.lastname}"
	        >
	        <br></br>
	        <p>Email:</p>
	        <input type="text" name="email"
	        	value="${sessionScope.user.email}"
	        >
	        <br></br>
	        <p>Password:</p>
	        <input type="password" name="password">
	        <br></br>
	         <p>Password(verification):</p>
	        <input type="password" name="password_v">
	        <br></br>
	        
	        <p>Campus:</p>
	        <select name="campus"> 
				<c:forEach var="campus" items="${campus_list}">
					<option value="${campus.id}">${campus.name}</option>
				</c:forEach>
			</select> 
	        <br></br>
	        <input type="submit" value="Edit" />
	    </form>
	   </div>
	</body>
</html>