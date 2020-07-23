<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String str = "123"; // 이건 변수선언임
request.setAttribute("str","123"); // 이건 str라는 키값에 213이라는 value가 있는 맵개념임
request.setAttribute("str1","test");
request.setAttribute("list",null);
%>
<c:if test="${str eq '123' && str1 == 'test'}">
str은 변수는 아니고 attribute키인데 무튼 123맞음<br>
str1은 test맞음<br>
</c:if>
<c:if test="${str ne '123'}">
str은 변수는 아니고 attribute키인데 무튼 123아님<br>
</c:if>

<c:choose>

	<c:when test="${str=='123'}">
	str은 123입니다<br>
	</c:when>
	<c:when test="${str1=='test1' }">
	str은 test1입니다
	</c:when>
	<c:otherwise>
	str은 123이 아니고 sr1도 test1이 아니다
	</c:otherwise>
</c:choose>

<c:if test="${list == null}">
리스트가 없네요?
</c:if>
<c:if test="${empty list}">
리스트가 비어있네여
</c:if>



</body>
</html>