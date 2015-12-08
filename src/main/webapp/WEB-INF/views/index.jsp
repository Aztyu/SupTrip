<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>SupTrip</title>
		<!-- CSS -->
		<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
		<link rel="icon" href="/favicon.ico" type="image/x-icon">
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
        <li><a href="${pageContext.request.contextPath}/logout">The home of SUPINFO own trip website</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        </ul>
    </div>
  </div>

</nav>

		<div class="baniere">
		<img src="<c:url value="/resources/image/carte.png"/>" >
		</div>
		
		<div class="formu">
		
		<h4>
			There are currently ${ users } users and ${ trips } trips organized.
			<br></br>
			Welcome aboard !!
			<br></br>
		</h4>
		<div id="login">
		
		<h3><span class="fontawesome-lock"></span>Sign In</h3>
		<fieldset>
  			<form method="POST" action="${pageContext.request.contextPath}/loginRequest">
	        <p>ID Booster :</p>
	        <input type="text" name="id">
	        <br></br>
	        <p>Password :</p>
	        <input type="password" name="password">
	        <br></br>
	        <input type="submit" value="Connect" />
	    </form>
	    
		<c:if test="${not empty message}">
			<p style="color:red">${message}</p>
		</c:if>
		</fieldset>
		</div>
		</div>
		
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/index.js"/>"></script>
	</body>
</html>
