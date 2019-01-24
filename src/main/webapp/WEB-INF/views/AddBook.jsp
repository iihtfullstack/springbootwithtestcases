<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<body>
	<div id ="addBook">
	<tr>
		<td>Add a book</td>
		</br>
	</tr>
	</div>
	<div>
	<tr>
	
	
	<form action="/book" method="POST">
	<td>Enter a unique ID for the bookId</td>
		<input type="number" name="bookId"><br> 
		<td>Enter a title for the book</td>
		<input type="string" name="title"><br> 
		<td>Enter a price for the book</td>
		<input type="number" name="price"><br> 
		<td>Enter the volume number</td>
		<input type="number" name="volume"><br> 
		<td>Enter the publish date in the format YYYY-MM-DD</td>
		<input type="date" name="date"><br> 
		<input type="submit" value="Submit">
	</form>
	
	</tr>
	</div>
<body>
</html>