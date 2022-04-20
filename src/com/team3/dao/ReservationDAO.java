package com.team3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import com.team3.dto.ReservationVO;
import com.team3.dto.ProductVO;

import util.DBManager;


public class ReservationDAO  {
	
	private ReservationDAO() {	
		
	}
	
	private static ReservationDAO instance = new ReservationDAO();
	
	public static ReservationDAO getInstance() {
		return instance;
		
	}


	public int insertReservation(ReservationVO rVo) {
		
		String sql = "insert into reservation_info values(?,reservation_info_seq.nextval(4,0),?,?,?,?,?,?";
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		
		try {
			// 1. jdbc 드라이버 로드 : forName(className)
			// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
			conn = DBManager.getConnection();
	
			// 3. 쿼리문을 실행하기 위한 객체 생성
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rVo.getResr_date());
			
			pstmt.setString(2, rVo.getResr_time());
			pstmt.setString(3, rVo.getResr_store_need());	
			pstmt.setString(4, rVo.getResr_usingtime());
			pstmt.setInt(5, rVo.getResr_person());
			pstmt.setString(6, rVo.getResr_info());
			pstmt.setString(7, rVo.getResr_before_info());
			
			
			// 4. 쿼리 실행 및 결과 처리
			// executeUpdate(sql)	- insert update delete	
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}		
		return result;		
	}

	
	public ReservationVO detailProduct(String user_id) {
		String sql = "select * from reservation_info where user_id=?";
		ReservationVO rVo = new ReservationVO();
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rVo.setUser_id(rs.getString("user_id"));
				rVo.setResr_number(rs.getInt("resr_number"));
				rVo.setResr_user_name(rs.getString("resr_user_name"));
				rVo.setResr_user_tel(rs.getString("resr_user_tel"));
				rVo.setResr_store_name(rs.getString("resr_store_name"));
				rVo.setResr_date(rs.getString("resr_date"));
				rVo.setResr_time(rs.getString("resr_time"));
				rVo.setResr_store_need(rs.getString("resr_store_need"));
				rVo.setResr_usingtime(rs.getString("resr_usingtime"));
				rVo.setResr_person(rs.getInt("resr_person"));
				rVo.setResr_info(rs.getString("resr_info"));
				rVo.setResr_before_info(rs.getString("resr_before_info"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return rVo;
	}

	
}


