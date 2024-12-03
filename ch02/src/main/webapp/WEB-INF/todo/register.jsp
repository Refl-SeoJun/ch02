<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/todo/register" method="post">
	
		제목:<input type="text" name="title"><br>
		날짜:<input type="date" name="dueDate">
		완료여부<input type="checkbox" name="completed" value="yes"><br>
		<button type="reset">다시쓰기</button><button type="submit">작성</button>
	</form>
</body>
</html>