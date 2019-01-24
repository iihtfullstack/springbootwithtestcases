<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete a Book</title>
</head>
<body>
<div>
Enter a Book ID to delete
</div>
	<form action="/book/delete" method="POST">
	
		<input type="number" name="bookId"><br> 
		
		<input type="submit" value="Submit">
	</form>
</body>
</html>

