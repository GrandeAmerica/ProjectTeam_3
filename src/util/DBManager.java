package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {

	// 데이터 베이스에 연결하기 위한 커넷션 얻어오는 메서드
	public static Connection getConnection(){
		Connection conn = null;
				
<<<<<<< HEAD
//		// 1. jdbc 드라이버 로드 : forName(className)
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
//		try {
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:orcl",
//					"ora_user",	"1234");
=======
		// 1. jdbc 드라이버 로드 : forName(className)
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
//		try {
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe",
//					"tae",	"tae");
>>>>>>> refs/remotes/develop/develop
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			//etc.
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// select
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try {
			if(rs != null)		rs.close();
			if(stmt != null)	stmt.close();
			if (conn != null)	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	// insert, update, delete
	public static void close(Connection conn, Statement stmt){
		try {
			if(stmt != null)	stmt.close();
			if (conn != null)	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	
	
}