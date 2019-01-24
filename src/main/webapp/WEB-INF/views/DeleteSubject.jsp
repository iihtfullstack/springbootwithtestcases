<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete a subject</title>
</head>
<body>
<div>
Enter a subject ID to delete
</div>
	<form action="/subject/delete" method="POST">
	
		<input type="number" name="subject"><br> 
		
		<input type="submit" value="Submit">
	</form>
</body>
</html>

