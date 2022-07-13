<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="main_container">
		<h1>Expense Details</h1>
		<h3><a href="/expenses">Go Back</a></h3>
		<h3>${expense.expense}</h3>
		<h3>${expense.description}</h3>
		<h3>${expense.vendor}</h3>
		<h3>${expense.amount}</h3>
	</div>

</body>
</html>