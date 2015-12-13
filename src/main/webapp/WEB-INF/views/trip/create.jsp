<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Create Trips</title>
		<link href="<c:url value="/resources/js/library/jquery-ui/jquery-ui.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/js/library/jquery-ui/jquery-ui.structure.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/js/library/jquery-ui/jquery-ui.theme.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">		
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<%@ include file="/WEB-INF/views/include/favicon.jsp" %>
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
	<h1>Create a new trip</h1>
	<br></br>
		<form method="POST" action="${pageContext.request.contextPath}/auth/create/tripRequest">
        <p>Description: (40 characters max)</p>
        <input type="text" name="description">
        <br></br>
        <p>Departure:</p>
        <select name="campus_start"> 
			<c:forEach var="campus" items="${campus_list}">
				<option value="${campus.id}">${campus.name}</option>
			</c:forEach>
		</select> 
		<br></br>
		<p>Arrival:</p>
        <select name="campus_end"> 
			<c:forEach var="campus" items="${campus_list}">
				<option value="${campus.id}">${campus.name}</option>
			</c:forEach>
		</select>
		<br></br>
		<p>Departure date:</p>
		<input name="date" type="text" id="datepicker">
		 <br></br>
		 <p>Departure time:</p>
		 <select name="hour"> 
		 <option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10" selected>10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			<option value="13">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
			<option value="21">21</option>
			<option value="22">22</option>
			<option value="23">23</option>
		</select>
		
		<select name="minute"> 
			<option value="0">0</option>
			<option value="5">5</option>
			<option value="10" selected>10</option>
			<option value="15">15</option>
			<option value="20">20</option>
			<option value="25">25</option>
			<option value="30">30</option>
			<option value="35">35</option>
			<option value="40">40</option>
			<option value="45">45</option>
			<option value="50">50</option>
			<option value="55">55</option>
		</select>
     	<br></br>
        <input type="submit" value="Create new trip" />
    </form>
    
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/library/jquery-ui/jquery-ui.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/tripcreate.js"/>"></script>
	</div>
	</body>
</html>