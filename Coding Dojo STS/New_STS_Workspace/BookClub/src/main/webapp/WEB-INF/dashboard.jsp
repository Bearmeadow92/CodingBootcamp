<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Book Share</title>
</head>
<body>
	<div class="container">
		<h1>Welcome <c:out value="${user.firstName}"/>!</h1>
		<div>Books from everyone's shelves:</div>
		<a href="/books/new">+ Add to my shelf</a>
		<a href="/">Logout</a>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td>
						<c:out value="${book.id}"/>
						</td>
						<td>
						<a href="/books/${book.id}">${book.title}</a>
						</td>
						<td>
						<c:out value="${book.author}"/>
						</td>
						<td>
						<c:out value="${user.firstName}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>