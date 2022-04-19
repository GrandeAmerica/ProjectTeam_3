package com.team3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
		String sql = "insert into reservation_info values(?,reservation_info_seq.nextval(4,0),?,?,?,?";
		
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
			
			pstmt.setString(1, rVo.getUser_id());
			
			pstmt.setInt(2, rVo.getResr_number());
			pstmt.setString(4, rVo.getResr_user_name());
			pstmt.setString(5, rVo.getResr_user_tel());
			pstmt.setString(6, rVo.getResr_store_name());
			
			pstmt.setString(9, rVo.getResr_store_need());
			
			pstmt.setInt(11, rVo.getResr_person());
			pstmt.setString(12, rVo.getResr_info());
			pstmt.setString(13, rVo.getResr_before_info());
			
			
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
		String sql = "select * from reservation_info where code=?";
		ReservationVO pVo = new ReservationVO();
		
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
				pVo.setUser_id(rs.getString("user_id"));
				pVo.setResr_number(rs.getInt("resr_number"));
				pVo.setResr_user_name(rs.getString("resr_user_name"));
				pVo.setResr_user_tel(rs.getString("resr_user_tel"));
				pVo.setResr_store_name(rs.getString("resr_store_name"));
				pVo.setResr_date(rs.getDate("resr_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pVo;
	}


	
}


