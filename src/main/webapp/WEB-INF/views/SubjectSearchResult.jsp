<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject search results</title>
</head>
<body>

<c:forEach var="subject" items="${subjectSearchResult}">
${subject.getSubject()} &nbsp;&nbsp;&nbsp;
${subject.getSubTitle()} <br/>
</c:forEach>
</body>
</html>

