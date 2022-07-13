<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
			<p>
				Dojo:
				<form:errors path="dojolocation"/>
				<form:select path="dojolocation">
					<c:forEach var="dojo" items="${dojos}">
						<form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				First Name:
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
			</p>
			<p>
				Last Name:
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
			</p>
			<p>
				Age:
				<form:errors path="age"/>
				<form:input path="age"/>
			</p>
			<input type="submit" value="Create"/>
		</form:form>
	</div>
</body>
</html>