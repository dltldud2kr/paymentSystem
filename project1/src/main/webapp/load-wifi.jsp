<%@page import="db.WifiInfo"%>
<%@page import="java.util.List"%>
<%@page import="db.WifiService"%>
<%@page import="db.TbPublicWifiInfo"%>
<%@page import="db.ApiExplorer"%>
<%@page import="java.io.IOException"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
TbPublicWifiInfo tw = new TbPublicWifiInfo();
%>

<script>
		<%
			ApiExplorer api = new ApiExplorer();
		
			try {
				api.apiCall();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		%>
 
</script>

<body>
<h1><center> <%=api.totalcnt%> 개의 WIFI정보를 정상적으로 저장하였습니다. <center/></h1>
<br>
<a href="publicWifiService.jsp"><center>홈으로 가기</center></a>

	
</body>
</html>