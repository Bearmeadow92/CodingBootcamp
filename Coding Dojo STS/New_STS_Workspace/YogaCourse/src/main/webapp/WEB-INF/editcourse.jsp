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
<title>Edit Course</title>
</head>
<body>
	<div class="container">
		<h1>Edit Course</h1>
		<form:form action="/classes/edit/${yogaObj.id} " method="post" modelAttribute="yogaObj">
			<input type="hidden" name="_method" value="put">
			<form:input type="hidden" path="creator" value="${user_id}" />
			<p>
					Name:
					<form:input path="name" />
					<form:errors path="name" />
				</p>
				<p>
					Day of Week:
					<form:input path="dayOfWeek" />
					<form:errors path="dayOfWeek" />
				</p>
				<p>
				
					Drop-in Price:
					<form:input type="number" step="any" value="1" path="dropInPrice" />
					<form:errors path="dropInPrice" />
				</p>
				<p>
					Description:
					<form:input type="textarea" cols="30" rows="5" path="description" />
					<form:errors path="description" />
				</p>
				<button>Submit</button>
			</form:form>
			<form action="/dashboard"><button>Cancel</button>
			</form>
			
		<form action="/classes/delete/${yogaObj.id}" method="post">			
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>