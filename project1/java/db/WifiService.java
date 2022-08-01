package db;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WifiService {
	
	TbPublicWifiInfo tw = new TbPublicWifiInfo();
	WifiInfo wi = new WifiInfo ();

	public List<WifiInfo> list(){
		
		List<WifiInfo> wifiList = new ArrayList<>();
		
        String url = "jdbc:mariadb://localhost:3306/project_db";
        String dbUserId = "projectuser";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;


        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            statement = connection.createStatement();


            String sql = " select *, "
            		+ "    (6371*acos(cos(radians(126.8512))*cos(radians(X좌표))*cos(radians(Y좌표) "
            		+ "    -radians(37.541462))+sin(radians(126.8512))*sin(radians(X좌표)))) "
            		+ "    as distance\r\n"
            		+ " from TbPublicWifiInfo "
            		+ " order by distance "
            		+ " limit 0,20; " ;



            rs = statement.executeQuery(sql);

            while(rs.next()){
            	wi.set거리(rs.getString("거리"));
            	wi.set관리번호(rs.getString("관리번호"));
            	wi.set자치구(rs.getString("자치구"));
            	wi.set와이파이명(rs.getString("와이파이명"));
            	wi.set도로명주소(rs.getString("도로명주소"));
            	wi.set상세주소(rs.getString("상세주소"));
            	wi.set설치위치(rs.getString("설치위치"));
            	wi.set설치유형(rs.getString("설치유형"));
            	wi.set설치기관(rs.getString("설치기관"));
            	wi.set서비스구분(rs.getString("서비스구분"));
            	wi.set망종류(rs.getString("망종류"));
            	wi.set설치년도(rs.getString("설치년도"));
            	wi.set실내외구분(rs.getString("실내외구분"));
            	wi.setWifi접속환경(rs.getString("wifi접속환경"));
            	wi.setX좌표(rs.getDouble("X좌표"));
            	wi.setY좌표(rs.getDouble("Y좌표"));
            	wi.set작업일자(rs.getString("작업일자"));
            	
            	
            	wifiList.add(wi);		// 리스트에 추가 
            	
            	System.out.println("select 불러오기 완료!!");


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (statement != null && !statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return wifiList;

    }

    public void dbInsert(TbPublicWifiInfo tw){
        String url = "jdbc:mariadb://localhost:3306/project_db";
        String dbUserId = "projectuser";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;


        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            
            
            String sql = " insert into TbPublicWifiInfo (관리번호, 자치구, 와이파이명, 도로명주소, 상세주소, 설치위치, 설치유형, 설치기관, 서비스구분, 망종류, 설치년도, 실내외구분, wifi접속환경, X좌표, Y좌표, 작업일자) " +
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";


            preparedStatement = connection.prepareStatement(sql);

            
            preparedStatement.setString(1, tw.get관리번호());
            preparedStatement.setString(2, tw.get자치구());
            preparedStatement.setString(3, tw.get와이파이명());
            preparedStatement.setString(4, tw.get도로명주소());
            preparedStatement.setString(5, tw.get상세주소());
            preparedStatement.setString(6, tw.get설치위치());
            preparedStatement.setString(7, tw.get설치유형());
            preparedStatement.setString(8, tw.get설치기관());
            preparedStatement.setString(9, tw.get서비스구분());
            preparedStatement.setString(10, tw.get망종류());
            preparedStatement.setString(11, tw.get설치년도());
            preparedStatement.setString(12, tw.get실내외구분());
            preparedStatement.setString(13, tw.getWIFI접속환경());
            preparedStatement.setDouble(14, tw.getX좌표());
            preparedStatement.setDouble(15, tw.getY좌표());
            preparedStatement.setString(16, tw.get작업일자());
            

            int affected = preparedStatement.executeUpdate();

            int cnt = 0;
            if(affected > 0) {
                System.out.println(" 저장 성공 ");
                cnt++;
              
            } else{
                System.out.println(" 저장 실패 ");
            }
            tw.setCount(cnt);
            
            System.out.println(cnt+"개의 데이터 저장!");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()){
                	preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    

}