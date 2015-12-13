<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>API user guide</h1>
	
	<h2>List of all trips:</h2>	
	<p>Returns a list of all the trips</p>
	<a href="${pageContext.request.contextPath}/api/trips">api/trips</a>
	
	<h2>List of all campuses:</h2>
	<p>Returns a list of all the existing campuses</p>
	<a href="${pageContext.request.contextPath}/api/campuses">api/campuses</a>
	
	<h2>List trip by campus:</h2>
	<p>Returns a list of all the trips from or to a campus, pass the campus id in the url</p>
	<a href="${pageContext.request.contextPath}/api/trips/1">api/trips/{campus_id}</a>
	
</body>
</html>