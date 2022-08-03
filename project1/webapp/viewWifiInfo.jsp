<%@page import="db.WifiInfo"%>
<%@page import="java.util.List"%>
<%@page import="db.WifiService"%>
<%@page import="db.TbPublicWifiInfo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	WifiInfo wf = new WifiInfo();
	
	String L1 = request.getParameter("LAT");
	String L2 = request.getParameter("LNT");
	
	double lat = Double.parseDouble(L1);
	double lnt = Double.parseDouble(L2);
	
	WifiService wifiService = new WifiService();
	TbPublicWifiInfo tw = new TbPublicWifiInfo();
	List<WifiInfo> wifiList = wifiService.list(lat,lnt);
	wifiService.historyInsert(tw, lat, lnt);
	
	


%>
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
			
		}
		
		tr:nth-child(odd) {
			background-color:WhiteSmoke;
		}
		
		
		
	</style>
</head>
<body>

	<h1> 와이파이 정보 구하기 </h1>
<p><a href="publicWifiService.jsp">홈</a>ㅣ
	<a href="history.jsp">위치 히스토리 목록</a>ㅣ
	<a href>Open Api 와이파이 정보 가져오기</a>
</p>
<form action="viewWifiInfo.jsp"method="post">
LAT: <input type="text" name="LAT"> , LNT: <input type= "text" name="LNT"> 
<input type="submit" value="내 위치 가져오기"> 
<input type="button" value="근처 WIFI 정보 보기">
</form>

<br> 


  
	<%
	
	%>
	
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
				<%
					for(WifiInfo wifiInfo : wifiList){
				%>
						<tr>

							<td> <%=wifiInfo.get거리()%> </td>
							<td> <%=wifiInfo.get관리번호()%> </td>
							<td> <%=wifiInfo.get자치구()%> </td>
							<td> <%=wifiInfo.get와이파이명()%> </td>
							<td> <%=wifiInfo.get도로명주소()%> </td>
							<td> <%=wifiInfo.get상세주소()%> </td>
							<td> <%=wifiInfo.get설치위치()%> </td>
							<td> <%=wifiInfo.get설치유형()%> </td>
							<td> <%=wifiInfo.get설치기관()%> </td>
							<td> <%=wifiInfo.get서비스구분()%> </td>
							<td> <%=wifiInfo.get망종류()%> </td>
							<td> <%=wifiInfo.get설치년도()%> </td>
							<td> <%=wifiInfo.get실내외구분()%> </td>
							<td> <%=wifiInfo.getWifi접속환경()%> </td>
							<td> <%=wifiInfo.getX좌표()%> </td>
							<td> <%=wifiInfo.getY좌표()%> </td>
							<td> <%=wifiInfo.get작업일자()%> </td>
						</tr>
				<% 
					}
				%>
				
			</tr>
		</tbody>
	</table>
	
	

</body>
</html>