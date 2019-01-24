<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search subject</title>
</head>
<body>
<div>
Enter first few characters or just submit to retrieve all subjects
</div>
	<form action="/subject/search" method="POST">
	
		<input name="subTitle"><br> 
		
		<input type="submit" value="Submit">
	</form>
</body>
</html>

