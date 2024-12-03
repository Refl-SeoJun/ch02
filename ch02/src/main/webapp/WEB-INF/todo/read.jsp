<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 조회</title>
</head>
<body>

글번호: ${dto.tno}<br>
제목: ${dto.title}<br>
날짜: ${dto.dueDate}<br>
완료여부: ${dto.finished}<br>
<button onclick="location.href='/todo/modify?tno=${dto.tno}'">수정하기</button>
</body>
</html>