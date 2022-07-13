<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<div class="container">
		<h1>New Dojo</h1>
		<form:form action="/dojos/new" method="post" modelAttribute="dojo">
			<p>
				Name:
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			<input type="submit" value="Create"/>
		</form:form>
	</div>
</body>
</html>