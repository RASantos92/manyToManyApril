<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Create game with Genre </h1>
	<form:form action="/games/process/create" method="post" modelAttribute="game">
	<div class="form-group">
        <label>Title</label>
        <form:input path="title" class="form-control" />
        <form:errors path="title" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Genres</label>
        <form:input path="formGenres" class="form-control" />
        <form:errors path="formGenres" class="text-danger" />
    </div>
    <form:select path="genres">
    	<c:forEach var="genre" items="${allGenres}">
    		<form:option value="${genre.id}" path="genres">
    			<c:out value="${genre.name}"/>
    		</form:option>
    	</c:forEach>
    </form:select>
	<input type="submit" value="create game" class="btn btn-success"/>
	</form:form>
</body>
</html>