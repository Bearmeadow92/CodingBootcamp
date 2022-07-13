<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<title>Read Share</title>
</head>
<body>
	<h1>Save Travels</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Expense</th>
		            <th>Vendor</th>
		            <th>Amount</th>
		        </tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="oneExpense" items="${expense}" >
		    		<tr>
				    	<td>
					    	<a href="expenses/${oneExpense.id}/show"><c:out value="${oneExpense.expense}"/></a>
	 			    	</td>
					    <td>
							<c:out value="${oneExpense.vendor}"/>
						</td>
						<td>
							<c:out value="${oneExpense.amount}"/>
						</td>
						<td>
							<a href="/expenses/${oneExpense.id}/edit" >edit</a>
						</td>
						<td>
					<form action="/expenses/${oneExpense.id}/delete" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
						</td>
					</tr>
				</c:forEach>
		    </tbody> 
		</table>

<form:form action="/expenses" method="post" modelAttribute="expenses">
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