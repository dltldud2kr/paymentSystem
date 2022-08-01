<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 바로 double로 받을 수 있는지 확인하기
	String L1 = request.getParameter("LAT");
	String L2 = request.getParameter("LNT");
	
	double lat = Double.parseDouble(L1);
	double lnt = Double.parseDouble(L2);
	
	double sum;
	sum = lat - lnt ;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=lat%></h1>
	<h1><%=lnt%></h1>
	

</body>
</html>