<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninjas" items="${dojo.ninjas}">
					<tr>
						<td>
							<c:out value="${ninjas.firstName}"/>
						</td>
						<td>
							<c:out value="${ninjas.lastName}"/>
						</td>
						<td>
							<c:out value="${ninjas.age}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>