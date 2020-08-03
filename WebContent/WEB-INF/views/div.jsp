<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div.sido{
	border : 30px ridge #2F4F4F;
	border-color: red yellow green blue;
	width : 50px;
	text-align : center;
	font-size : 20px;
	float : left;
	margin : 3px;
	font-face{
	font-family:"Typo_BabyHeartM";
	src:url("")
	}
}
</style>
</head>
<body>
<div class="sido selected">전체</div>
<c:forEach items="${sidoList}" var="sido" varStatus="idx">

	<c:if test="${fn:contains(sido,'충청') || fn:contains(sido,'경상') || fn:contains(sido,'전라')}">
		<div class="sido">${fn:substring(sido,0,1)}${fn:substring(sido,2,3)}</div>
	</c:if>
	
	<c:if test="${!fn:contains(sido,'충청') && !fn:contains(sido,'경상') && !fn:contains(sido,'전라')}">
	 <div class="sido">${fn:substring(sido,0,2)}</div>
	</c:if>
  
   <c:if test="${idx.count==8}">
   	<br>
   </c:if>
</c:forEach>

<script>
function selectsido(sidoObj){
	
	
}
</script>
</body>
</html>