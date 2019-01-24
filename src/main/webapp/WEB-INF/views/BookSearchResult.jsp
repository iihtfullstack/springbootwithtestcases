<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book search results</title>
</head>
<body>

<c:forEach var="book" items="${bookSearchResult}">
${book.getBookId()} &nbsp;&nbsp;&nbsp;
${book.getTitle()} <br/>
</c:forEach>
</body>
</html>

