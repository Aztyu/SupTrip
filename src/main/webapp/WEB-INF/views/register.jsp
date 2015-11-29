<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/registerRequest">
        <p>ID Booster:</p>
        <input type="text" name="id_booster"
        	<c:if test="${not empty id}">
				value=${id}
			</c:if>
        >
        
        <p>Firstname:</p>
        <input type="text" name="firstname"
        	<c:if test="${not empty firstname}">
				value=${firstname}
			</c:if>
        >
        
        <p>Lastname:</p>
        <input type="text" name="lastname"
        	<c:if test="${not empty lastname}">
				value=${lastname}
			</c:if>
        >
        
        <p>Email:</p>
        <input type="text" name="email"
        	<c:if test="${not empty email}">
				value=${email}
			</c:if>
        >
        
        <p>Password:</p>
        <input type="password" name="password">
        
         <p>Password(verification):</p>
        <input type="password" name="password_v">
        
        <p>Campus:</p>
        <select name="campus"> 
			<c:forEach var="campus" items="${campus_list}">
				<option value="${campus.id}">${campus.name}</option>
			</c:forEach>
		</select> 
        
        <input type="submit" value="S'inscrire" />
    </form>
    
    <c:if test="${not empty message}">
		<p style="color:red">${message}</p>
	</c:if>
    

</body>
</html>