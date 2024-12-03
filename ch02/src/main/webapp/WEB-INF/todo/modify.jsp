<%@page import="org.zerock.jdbcex.dto.TodoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 수정</title>
</head>
<body>

<form action="/todo/modify" method="post">
글번호:<input type="number" name="tno" value="${dto.tno}" readonly><br>
제목:<input type="text" value="${dto.title}" name="title"><br>
날짜:<input type="text" value="${dto.dueDate}" name="dueDate"> <br>
완료여부:
    <%
    	TodoDTO dto = (TodoDTO) request.getAttribute("dto");
    	boolean finished = dto.isFinished();
        if (finished) {
    %>
        <input type="checkbox" name="finished" value="yes" checked><br>
    <% 
        } else { 
    %>
        <input type="checkbox" name="finished" value="yes"><br>
    <% 
        }  
    %><br>
<input type="submit" value="수정하기">
<button type="button" onclick="location.href='/todo/delete?tno=${dto.tno}'">삭제하기</button>
</form>
</body>
</html>