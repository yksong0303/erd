<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div.sido{
	border : 24px ridge #2F4F4F;
	border-color: red yellow green blue;
	width : 50px;
	text-align : center;
	font-size : 20px;
	float : left;
	margin : 3px;
	font-family:"궁서체";	
	cursor : pointer;
}
div.selected{
	background-color:pink;
	color : white;
} 
div.sido:hover{
	backround : hotpink;
}
div.gugun{
	border : 10px ridge #4F8F8F;
	border-color: pink yellow green blue;
	width : 20px;
	text-align : center;
	font-size : 5px;
	float : left;
	margin : 3px;
	font-family:"궁서체";	
}
div.dong{
	border : 10px ridge #10F20F20F;
	border-color: white red green blue;
	width : 20px;
	text-align : center;
	font-size : 5px;
	float : left;
	margin : 3px;
	font-family:"궁서체";	
}
</style>
</head>
<body>

<div class="sido selected">전체</div>
<c:forEach items="${sidoList}" var="sido" varStatus="idx">
	<div class="sido
	<c:if test="${param.sido==sido}">
	selected
	</c:if>
	" onclick="selectSido(this)" data-sido="${sido}">
		<c:if test="${fn:contains(sido,'충청') || fn:contains(sido,'경상') || fn:contains(sido,'전라') }">
			${fn:substring(sido,0,1)}${fn:substring(sido,2,3)}
		</c:if>
		<c:if test="${!fn:contains(sido,'충청') && !fn:contains(sido,'경상') && !fn:contains(sido,'전라') }">
			${fn:substring(sido,0,2)}
		</c:if>
	</div>
	<c:if test="${idx.count==8}">
		<br>
	</c:if>
</c:forEach>

<div class="gugun selected">전체</div>
<c:forEach items="${gugunList}" var="gugun" varStatus="idx">
	<div class="gugun" onclick="selectGugun(this)" data-gugun="${gugun}">
		${fn:substring(gugun,0,2)}
	</div>
	<c:if test="${idx.count%8==0}">
		<br>
	</c:if>
</c:forEach>

<div class="dong selected">전체</div>
<c:forEach items="${dongList}" var="dong" varStatus="idx">
	<div class="dong" data-dong="${dong}">
		${fn:substring(dong,0,2)}
	</div>
	<c:if test="${idx.count%8==0}">
		<br>
	</c:if>
</c:forEach>


<script>
function selectSido(sidoObj){
	var sido = sidoObj.getAttribute('data-sido');
	location.href='/div?sido='+ sido;
}
function selectGugun(gugunObj){
	var gugun = gugunObj.getAttribute('data-gugun');
	document.querySelector('div.selected[data-sido]')getAttribute('data-sido');
	location.href = '/div?sido=' + sido + '&gugun=' +gugun;
}

</script>
</body>
</html>