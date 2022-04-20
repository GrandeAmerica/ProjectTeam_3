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

	public ReservationVO detailProduct(String user_id) {
		String sql = "select * from reservation_info where code=?";
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
				rVo.setResr_date(rs.getDate("resr_date"));
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


