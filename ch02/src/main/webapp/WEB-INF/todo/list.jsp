<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 목록</title>
</head>
<body>
<h1>할일 목록</h1> <button onclick="location.href='/todo/register'">할일 쓰기</button><br>

<c:forEach items="${list}" var="dto">
${dto.tno}. 
<a href="/todo/read?tno=${dto.tno}">${dto.title}</a> 
${dto.dueDate} ${dto.finished ? "완료" : "미완료" } <br>
</c:forEach>

</body>
</html>