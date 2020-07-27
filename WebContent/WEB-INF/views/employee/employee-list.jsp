<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ㅅㅂ</title>
</head>
<body>
ㅅㅂ놈아 나와라

<table border='1'>
	<tr>
		<th>사원번호</th>
		<th>사원이름</th>
		<th>입사일</th>
		<th>연봉</th>
		<th>계급</th>
	</tr>	
		<c:if test="${empty gradeList}">
		<tr>
			<td colspan="3">내용이 없습니다</td>
		</tr>
	</c:if>
	<c:forEach items="${emp}" var="emp">
		<tr>
			<td>${emp.emp_no}</td>
			<td>${emp.emp_name}</td>
			<td>${emp.emp_credat}</td>
			<td>${emp.emp_salary}</td>
			<td>${emp.grd_no}</td>
			<td>
				<c:forEach items="${grdList}" var="grd">
				
				</c:forEach>
			</td>
		</tr>
	</c:forEach>	
</table>
<a href="/views/employee/employee-insert"><button>사원추가</button></a>
</body>
</html>