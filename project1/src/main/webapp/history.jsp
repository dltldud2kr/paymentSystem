<%@page import="db.WifiInfo"%>
<%@page import="java.util.List"%>
<%@page import="db.WifiService"%>
<%@page import="db.TbPublicWifiInfo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		th{
			height: 50px;
			background-color : MediumSeaGreen;
			color : white;
		}
		td{
			height: 30px;
		}
		
		th, td {
			border:solid 1px #000;
			border-color : lightGray;
			
		}	
		table {
			border-collapse: collapse;
			
			width:100%;
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
WifiService wifiService = new WifiService();
TbPublicWifiInfo tw = new TbPublicWifiInfo();
List<WifiInfo> hisList = wifiService.history();
%>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>조회일자</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<%
				int cnt=1;
					for(WifiInfo hisInfo : hisList){
						hisInfo.setId(cnt);
				%>
						<tr>
				
							<td><%=hisInfo.getId()%></td>
							<td><%=hisInfo.getXvalue()%></td>
							<td><%=hisInfo.getYvalue()%></td>
							<td><%=hisInfo.getInquiry_date()%></td>
							<td><center><input type = "button" value="삭제"></center></td>
						</tr>
				<%
				cnt++;
					}
				%>	
			
			</tr>
		</tbody>
	</table>

</body>
</html>