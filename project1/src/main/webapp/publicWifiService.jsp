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
	<style>
		th{
			height: 70px;
			background-color : MediumSeaGreen;
			color : white;
			
		}
		
		th, td {
			border:solid 1px #000;
			border-color : lightGray;
			
		}	
		table {
			border-collapse: collapse;
			width:100%;
			
		}
		
		td{
			height: 100px;
		}
		
		table > thead > tr > th:nth-child(1) {
	width:100px;
}
		
	</style>
	


</head>
<body>


<h1> 와이파이 정보 구하기 </h1>
<p><a href="publicWifiService.jsp">홈</a>ㅣ
	<a href="history.jsp">위치 히스토리 목록</a>ㅣ
	<a href="load-wifi.jsp">Open Api 와이파이 정보 가져오기</a>
	
	
</p>
<form action="viewWifiInfo.jsp"method="get">
LAT: <input type="text" name="LAT"> , LNT: <input type= "text" name="LNT"> 	
<input type="submit" value="근처 WIFI 정보 보기">
</form>
<br>

	<table>
		<thead>
			<tr>
				<th>거리(Km)</th>
				<th>관리번호</th>
				<th>자치구</th>
				<th>와이파이명</th>
				<th>도로명주소</th>
				<th>상세주소</th>
				<th>설치위치(층)</th>
				<th>설치유형</th>
				<th>설치기관</th>
				<th>서비스구분</th>
				<th>망종류</th>
				<th>설치년도</th>
				<th>실내외구분</th>
				<th>WIFI접속환경</th>
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>작업일자</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="17"><center>위치 정보를 입력한 후에 조회해 주세요.</center><td>
			</tr>
		</tbody>
	</table>
	

</body>
</html>