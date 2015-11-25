<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/campus">
        <p>Campus name :</p>
        <input type="text" name="name">
        
        <p>Address :</p>
        <input type="text" name="address">
        
        <p>City :</p>
        <input type="text" name="city">
        
        <p>Postal code:</p>
        <input type="text" name="postal_code">
        
        <input type="submit" value="Create campus" />
    </form>

</body>
</html>