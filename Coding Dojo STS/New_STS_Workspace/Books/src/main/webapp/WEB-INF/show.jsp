<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
</head>
<body>
	
	<h1><c:out value="${book.title}"/></h1>
	<h4><c:out value="${book.description}"/></h4>
	<h4><c:out value="${book.language}"/></h4>
	<h4><c:out value="${book.numberOfPages}"/></h4>
	
</body>
</html>