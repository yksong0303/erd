<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="emp_no" value="${employee.emp.no }">
<table border="1">
	<tr>
		<th>번호</th>
		<th>${employee.emp_no }</th>
	</tr>
	
	<tr>
		<th>이름</th>
		<th><input type="text" name="emp_name" value="${empList.emp_name }"></th>
	</tr>
	
	<tr>
		<th>날짜</th>
		<th>${employee.emp_credat }></th>
	</tr>
	
	<tr>
		<th>몸값</th>
		<th><input type="text" name="emp_salary" value="${employee.emp_salary }"></th>
	</tr>
	
	<tr>
		<th>섹시미</th>
		<th><input type="number" name="grd_no" value="${employee.grd_no }"></th>
	</tr>
	
	<tr>
		<th>재직중0/1</th>
		<th><input type="number" name="emp_active" value="${employee.emp_active }"></th>
	</tr>
	<tr>
		<th colspan="2"><button>수정</button></th>
	</tr>
</table>

</body>
</html>