<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Fruit Store</title>
</head> 
	<body>

		<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
		<tbody>
			<c:forEach var="fruit" items="${fruits}">
			    <tr>
			    	<td><c:out value="${fruit.name}"></c:out></td>
			    	<td><c:out value="${fruit.price}"></c:out></td>
			    </tr>
			</c:forEach>
		</tbody>
</table>
	</body>
</html>