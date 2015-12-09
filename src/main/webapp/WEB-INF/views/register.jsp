<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
		
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/logout">SupTrip</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
      <li><a href="#">The home of SUPINFO own trip website</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        </ul>
    </div>
  </div>
</nav>
<div class="formu">
	<form method="POST" action="${pageContext.request.contextPath}/registerRequest">
        <p>ID Booster:</p>
        <input type="text" name="id_booster"
        	<c:if test="${not empty id}">
				value=${id}
			</c:if>
        >
        <br></br>
        <p>Firstname:</p>
        <input type="text" name="firstname"
        	<c:if test="${not empty firstname}">
				value=${firstname}
			</c:if>
        >
        <br></br>
        <p>Lastname:</p>
        <input type="text" name="lastname"
        	<c:if test="${not empty lastname}">
				value=${lastname}
			</c:if>
        >
        <br></br>
        <p>Email:</p>
        <input type="text" name="email"
        	<c:if test="${not empty email}">
				value=${email}
			</c:if>
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
        <input type="submit" value="S'inscrire" />
    </form>
    
    <c:if test="${not empty message}">
		<p style="color:red">${message}</p>
	</c:if>
    
</div>
</body>
</html>