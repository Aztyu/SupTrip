<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/register">
        <p>ID Booster:</p>
        <input type="text" name="id_booster">
        
        <p>Firstname:</p>
        <input type="text" name="firstname">
        
        <p>Lastname:</p>
        <input type="text" name="lastname">
        
        <p>ID Booster:</p>
        <input type="text" name="email">
        
        <p>ID Booster:</p>
        <input type="text" name="id_booster">
        
        <input type="submit" value="S'inscrire" />
    </form>

</body>
</html>