<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Trip creation</title>
		<link href="<c:url value="/resources/js/library/jquery-ui/jquery-ui.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/js/library/jquery-ui/jquery-ui.structure.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/js/library/jquery-ui/jquery-ui.theme.min.css"/>" rel="stylesheet">
	</head>
	<body>
		<form method="POST" action="${pageContext.request.contextPath}/auth/create/tripRequest">
        <p>Description:</p>
        <input type="text" name="description">
        
        <p>Departure:</p>
        <select name="campus_start"> 
			<c:forEach var="campus" items="${campus_list}">
				<option value="${campus.id}">${campus.name}</option>
			</c:forEach>
		</select> 
		
		<p>Arrival:</p>
        <select name="campus_end"> 
			<c:forEach var="campus" items="${campus_list}">
				<option value="${campus.id}">${campus.name}</option>
			</c:forEach>
		</select>
		
		<p>Departure date:</p>
		<input name="date" type="text" id="datepicker">
		 
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
     
        <input type="submit" value="Create new trip" />
    </form>
    
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/library/jquery-ui/jquery-ui.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/tripcreate.js"/>"></script>
	</body>
</html>