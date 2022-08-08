 package db;


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {

		TbPublicWifiInfo tw = new TbPublicWifiInfo();
		WifiService wm = new WifiService();
		
		public int totalcnt ;

		public void apiCall() throws IOException {
		
		Gson gson = new Gson();
		int cnt = 0;
		boolean cycle = true;
		
		StringBuilder sb = null ;  
		int a = 1;
		int b = 1000;
		
		while(cycle) {	
			System.out.println(b);


		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/

		urlBuilder.append("/" +  URLEncoder.encode("597a787670646c7436334a61706176","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
		urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
		urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
		urlBuilder.append("/" + URLEncoder.encode(""+a+"","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
		urlBuilder.append("/" + URLEncoder.encode(""+b+"","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
		urlBuilder.append("/" + URLEncoder.encode("20220301","UTF-8")); /* 서비스별 추가 요청인자들*/

		

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		System.out.println("Response code: " + conn.getResponseCode()); 
		BufferedReader rd;

		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {

				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		} else {

				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {

				sb.append(line);
		}
		
		rd.close();
		conn.disconnect();
	
		a = a + 1000;
		b = b + 1000;

		//row 값들을 가진 ArrayList 생성 
		ArrayList<TbPublicWifiInfo> arrayOfRow = new ArrayList<>();

		//파싱 
		JsonElement element = JsonParser.parseString(sb.toString());
		JsonObject object = element.getAsJsonObject();
		JsonObject tbObj = object.get("TbPublicWifiInfo").getAsJsonObject();
		JsonArray rowArray = tbObj.get("row").getAsJsonArray();
		totalcnt = tbObj.get("list_total_count").getAsInt();
		
		
		
		
		for(int j = 0; j < rowArray.size(); j++) {

			JsonObject rowobj = (JsonObject) rowArray.get(j);

			String X_SWIFI_MGR_NO = rowobj.get("X_SWIFI_MGR_NO").getAsString();
			String X_SWIFI_WRDOFC = rowobj.get("X_SWIFI_WRDOFC").getAsString();
			String X_SWIFI_MAIN_NM = rowobj.get("X_SWIFI_MAIN_NM").getAsString();
			String X_SWIFI_ADRES1 = rowobj.get("X_SWIFI_ADRES1").getAsString();
			String X_SWIFI_ADRES2 = rowobj.get("X_SWIFI_ADRES2").getAsString();
			String X_SWIFI_INSTL_FLOOR = rowobj.get("X_SWIFI_INSTL_FLOOR").getAsString();
			String X_SWIFI_INSTL_TY = rowobj.get("X_SWIFI_INSTL_TY").getAsString();
			String X_SWIFI_INSTL_MBY = rowobj.get("X_SWIFI_INSTL_MBY").getAsString();
			String X_SWIFI_SVC_SE = rowobj.get("X_SWIFI_SVC_SE").getAsString();
			String X_SWIFI_CMCWR = rowobj.get("X_SWIFI_CMCWR").getAsString();
			String X_SWIFI_CNSTC_YEAR = rowobj.get("X_SWIFI_CNSTC_YEAR").getAsString();
			String X_SWIFI_INOUT_DOOR = rowobj.get("X_SWIFI_INOUT_DOOR").getAsString();
			String X_SWIFI_REMARS3 = rowobj.get("X_SWIFI_REMARS3").getAsString();
			double LAT = rowobj.get("LAT").getAsDouble();
			double LNT = rowobj.get("LNT").getAsDouble();
			String WORK_DTTM = rowobj.get("WORK_DTTM").getAsString();
			cnt++;

			
			tw.set관리번호(X_SWIFI_MGR_NO);
			tw.set자치구(X_SWIFI_WRDOFC);
			tw.set와이파이명(X_SWIFI_MAIN_NM);
			tw.set도로명주소(X_SWIFI_ADRES1);
			tw.set상세주소(X_SWIFI_ADRES2);
			tw.set설치위치(X_SWIFI_INSTL_FLOOR);
			tw.set설치유형(X_SWIFI_INSTL_TY);
			tw.set설치기관(X_SWIFI_INSTL_MBY);
			tw.set서비스구분(X_SWIFI_SVC_SE);
			tw.set망종류(X_SWIFI_CMCWR);
			tw.set설치년도(X_SWIFI_CNSTC_YEAR);
			tw.set실내외구분(X_SWIFI_INOUT_DOOR);
			tw.setWIFI접속환경(X_SWIFI_REMARS3);
			tw.setX좌표(LAT);
			tw.setY좌표(LNT);
			tw.set작업일자(WORK_DTTM);
			
			wm.dbInsert(tw);
			
			if(cnt == totalcnt) {
				cycle = false;
				break;
			}
			
			System.out.println(cnt);
		}			
		sb = null;	
		}		
	
		
		
	}
		
}
