package db;

public class TbPublicWifiInfo{

	

	private String 관리번호;
	private String 자치구;
	private String 와이파이명;
	private String 도로명주소;
	private String 상세주소;
	private String 설치위치;
	private String 설치유형;
	private String 설치기관;
	private String 서비스구분;
	private String 망종류;
	private String 설치년도;
	private String 실내외구분;
	private String WIFI접속환경;
	private double X좌표;
	private double Y좌표;
	private String 작업일자;
	private int count;
	private double lat;
	private double lnt;
	private int total_count ;
	
	
	
	public int getTotal_count() {
		return total_count;
	}


	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLnt() {
		return lnt;
	}


	public void setLnt(double lnt) {
		this.lnt = lnt;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public TbPublicWifiInfo() {
		
	}


	public String get관리번호() {
		return 관리번호;
	}

	public void set관리번호(String 관리번호) {
		this.관리번호 = 관리번호;
	}

	public String get자치구() {
		return 자치구;
	}

	public void set자치구(String 자치구) {
		this.자치구 = 자치구;
	}

	public String get와이파이명() {
		return 와이파이명;
	}

	public void set와이파이명(String 와이파이명) {
		this.와이파이명 = 와이파이명;
	}

	public String get도로명주소() {
		return 도로명주소;
	}

	public void set도로명주소(String 도로명주소) {
		this.도로명주소 = 도로명주소;
	}

	public String get상세주소() {
		return 상세주소;
	}

	public void set상세주소(String 상세주소) {
		this.상세주소 = 상세주소;
	}

	public String get설치위치() {
		return 설치위치;
	}

	public void set설치위치(String 설치위치) {
		this.설치위치 = 설치위치;
	}

	public String get설치유형() {
		return 설치유형;
	}

	public void set설치유형(String 설치유형) {
		this.설치유형 = 설치유형;
	}

	public String get설치기관() {
		return 설치기관;
	}

	public void set설치기관(String 설치기관) {
		this.설치기관 = 설치기관;
	}

	public String get서비스구분() {
		return 서비스구분;
	}

	public void set서비스구분(String 서비스구분) {
		this.서비스구분 = 서비스구분;
	}

	public String get망종류() {
		return 망종류;
	}

	public void set망종류(String 망종류) {
		this.망종류 = 망종류;
	}

	public String get설치년도() {
		return 설치년도;
	}

	public void set설치년도(String 설치년도) {
		this.설치년도 = 설치년도;
	}

	public String get실내외구분() {
		return 실내외구분;
	}

	public void set실내외구분(String 실내외구분) {
		this.실내외구분 = 실내외구분;
	}

	public String getWIFI접속환경() {
		return WIFI접속환경;
	}

	public void setWIFI접속환경(String wIFI접속환경) {
		WIFI접속환경 = wIFI접속환경;
	}

	public double getX좌표() {
		return X좌표;
	}

	public void setX좌표(double x좌표) {
		X좌표 = x좌표;
	}

	public double getY좌표() {
		return Y좌표;
	}

	public void setY좌표(double y좌표) {
		Y좌표 = y좌표;
	}

	public String get작업일자() {
		return 작업일자;
	}

	public void set작업일자(String 작업일자) {
		this.작업일자 = 작업일자;
	}
	
	

}