<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your expense</title>
</head>
<body>
	<form:form action="/expenses/${expenses.id}/edit" method="put" modelAttribute="expenses">
	    <p>
	        <form:label path="expense">Expense Name:</form:label>
	        <form:errors path="expense"/>
	        <form:input path="expense"/>
	    </p>
	    <p>
	        <form:label path="vendor">Vendor:</form:label>
	        <form:errors path="vendor"/>
	        <form:input path="vendor"/>
	    </p>
	    <p>
	        <form:label path="amount">Amount:</form:label>
	        <form:errors path="amount"/>
	        <form:input path="amount"/>
	    </p>
	    <p>
	        <form:label path="description">Description:</form:label>
	        <form:errors path="description"/>     
	        <form:textarea type="description" path="description"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>  
</body>
</html>