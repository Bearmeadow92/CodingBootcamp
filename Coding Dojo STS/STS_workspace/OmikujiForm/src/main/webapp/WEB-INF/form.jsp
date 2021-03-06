<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>
	.container{
		content-align: center;
	
	}



</style>
</head>
<body>
    <div id= "container">
        <h1>Send an Omikuji!</h1>
    <%--     <h2>You have visited <c:out value="${count}"/> times</h2> --%>
        <form action = "/show" method="POST">
            <div>
            <h4>Pick any number from 5 to 25</h4>
            <select name= "num">
                <option value= "0">0</option>
                <option value= "5">5</option>
                <option value= "10">10</option>
                <option value= "15">15</option>
                <option value= "20">20</option>
            </select>
            </div>
            <div>
            <h4>Enter the name of any city.</h4>
            <input type="city" name="city"/>
            </div>
            <div>
            <h4>Enter the name of any real person.</h4>
            <input type="name" name="name"/>
            </div>
            <div>
            <h4>Enter professional endeavor or hobby.</h4>
            <input type="hobby" name="hobby"/>
            </div>
            <div>
            <h4>Enter any type of living thing.</h4>
            <input type="organism" name="organism"/>
            </div>
            <h4>Say something nice to someone.</h4>
            <input type="nice" name="nice"/>
            </div>
            <p>Send and show a friend</p>
            <button>Send</button>
        </form>
    </div>
</body>
</html>