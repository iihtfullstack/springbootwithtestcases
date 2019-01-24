<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<body>
	<div id ="addBook">
	<tr>
		<td>Add a Subject</td>
		</br>
	</tr>
	</div>
	<div>
	<tr>
	
	
	<form action="/subject" method="POST">
	<td>Enter a unique ID for the subject</td>
		<input type="number" name="subject"><br> 
		<td>Enter a title for the subject</td>
		<input type="string" name="subTitle"><br> 
		<td>Enter duration in hours</td>
		<input type="number" name="durationInHours"><br> 
		<td>Enter reference book ID's in numbers separated by comma  eg: 1,2. If you want to add it later, leave the field empty</td>
		<input type="string" name="refIds"><br>
		<input type="submit" value="Submit">
	</form>
	
	</tr>
	</div>
<body>
</html>