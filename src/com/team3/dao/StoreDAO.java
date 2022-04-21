package com.team3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team3.dto.StoreVO;

import util.DBManager;
public class StoreDAO {

		// 데이터 베이스에 접근하여 데이터를 획득하거나 설정
		// CRUD를 메서드로 구현한 클래스
		
		
		
		// Create (insert) - 회원 가입
		public int insertStoreInfo(StoreVO sVo) {
			
			String sql_insert_pstmt = "insert into store_info values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'm', ?, ?)";
			//String sql_insert_pstmt = "insert into store_info values('btestid01', 'c:\temp\test.jpg', '섬머셋호텔', '숙박업', '평일 : 오전00:00 - 오후00:00 마감', '주말 : 오전00:00 - 오후00:00 마감', '서울특별시 종로구 통의동 000-00 ', '머셋호텔', 'm', '가능', '비고없음')";
			//                                                       1  2  3  4  5  6  7  8  9  10 11   12 13 
//			String sql_insert_pstmt = "insert into store_info values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'm', ?, ? )";
			//String sql_insert_pstmt = "insert into store_info values(?, ?, ?, ?, '섬머셋호텔', '숙박업', '평일 : 오전00:00 - 오후00:00 마감', '주말 : 오전00:00 - 오후00:00 마감', '서울특별시 종로구 통의동 000-00 ', '섬머셋호텔', 'm', '가능', '비고없음')";
			//String sql_insert_pstmt = "insert into store_info values('btestid01', 'c:\temp\test1.jpg', 'c:\temp\test2.jpg','c:\temp\test3.jpg', '섬머셋호텔', '숙박업', '평일 : 오전00:00 - 오후00:00 마감', '주말 : 오전00:00 - 오후00:00 마감', '서울특별시 종로구 통의동 000-00 ', '섬머셋호텔', '010-1234-5678','m', '가능', '비고없음')";
		
			int result = -1;
			
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			
			
			try {
				// 1. jdbc 드라이버 로드 : forName(className)
				try {
					System.out.println("point01");
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
				System.out.println("point02");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ora_user", "1234");
		
				// 3. 쿼리문을 실행하기 위한 객체 생성
				pstmt = conn.prepareStatement(sql_insert_pstmt);
				pstmt.setString(1, sVo.getUserid());
				pstmt.setString(2, sVo.getStore_photo1());
				pstmt.setString(3, sVo.getStore_photo2());
				pstmt.setString(4, sVo.getStore_photo3());
				pstmt.setString(5, sVo.getStore_name());
				pstmt.setString(6, sVo.getStore_type());
				pstmt.setString(7, sVo.getStore_time());
				pstmt.setString(8, sVo.getStore_time_w());
				pstmt.setString(9, sVo.getStore_addr());
				pstmt.setString(10, sVo.getStore_addr_detail());
				pstmt.setString(11, sVo.getStore_tel());
				//pstmt.setString(12, sVo.getMemu_info());
				pstmt.setString(12, sVo.getParking());				
				pstmt.setString(13, sVo.getParking_detail());
			
				System.out.println("1.sVo.getUserid() =>" + sVo.getUserid());
				System.out.println("2.sVo.getStore_photo1() =>" + sVo.getStore_photo1());
				System.out.println("3.sVo.getStore_photo2() =>" + sVo.getStore_photo2());
				System.out.println("4.sVo.getStore_photo3() =>" + sVo.getStore_photo3());
				System.out.println("5.sVo.getStore_name() =>" + sVo.getStore_name());
				System.out.println("6.sVo.getStore_type() =>" + sVo.getStore_type());
				System.out.println("7.sVo.getStore_time() =>" + sVo.getStore_time());
				System.out.println("8.sVo.getStore_time_w() =>" + sVo.getStore_time_w());
				System.out.println("9.sVo.getStore_addr() =>" + sVo.getStore_addr());
				System.out.println("10.sVo.getStore_addr_detail() =>" + sVo.getStore_addr_detail());
				System.out.println("11.sVo.getStore_tel() =>" + sVo.getStore_tel());
				//System.out.println("12.sVo.getMemu_info() =>" + sVo.getMemu_info());
				System.out.println("12.sVo.getParking() =>" + sVo.getParking());
				System.out.println("13.sVo.getParking_detail() =>" + sVo.getParking_detail());
				
				// 4. 쿼리 실행 및 결과 처리
				// executeQuery(sql)	- select
				// executeUpdate(sql)	- insert update delete	
				result = pstmt.executeUpdate();
				
				System.out.println(result);
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null)		rs.close();
					if(pstmt != null)	pstmt.close();
					if (conn != null)	conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}			
			}
			
			return result;	
		}

		public int insertStoreInfo_Menu(StoreVO sVo) {
			String sql_insert_pstmt = "update store_info set menu_info = ? where user_id = ?";
			
			int result = -1;
			
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			
			
			try {
				// 1. jdbc 드라이버 로드 : forName(className)
				try {
					System.out.println("point01");
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
				System.out.println("point02");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ora_user", "1234");
		
				// 3. 쿼리문을 실행하기 위한 객체 생성
				pstmt = conn.prepareStatement(sql_insert_pstmt);
				pstmt.setString(1, sVo.getMenu_info());
				pstmt.setString(2, sVo.getUserid());
			
				System.out.println("1.sVo.getMenu_info() =>" + sVo.getMenu_info());
				System.out.println("2.sVo.getUserid() =>" + sVo.getUserid());
				
				// 4. 쿼리 실행 및 결과 처리
				// executeQuery(sql)	- select
				// executeUpdate(sql)	- insert update delete	
				result = pstmt.executeUpdate();
				
				System.out.println(result);
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null)		rs.close();
					if(pstmt != null)	pstmt.close();
					if (conn != null)	conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}			
			}
			
			return result;	
		}	
		private StoreDAO() {// 디폴트 생성자 만들고, 밖에서 못쓰게 private
		}

		private static StoreDAO instance = new StoreDAO(); // 필드도 가져다 못쓰게 막아놓음

		public static StoreDAO getInstance() { // 제공은 해줄게. getInstance
			return instance;
		}
		// Search (select) - 업체 검색
			public List<StoreVO> searchStore(String query) {
				String sql_select_search = "select store_photo1, store_name, store_type, store_addr from store_info where store_name like ?";

				List<StoreVO> list = new ArrayList<StoreVO>();
				
				StoreVO sVo = null;

				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql_select_search);
					pstmt.setString(1, "%" + query + "%");

					rs = pstmt.executeQuery();

					while (rs.next()) {
						sVo = new StoreVO();
						
						sVo.setStore_photo1(rs.getString("store_photo1"));
						sVo.setStore_name(rs.getString("store_name"));
						sVo.setStore_type(rs.getString("store_type"));
						sVo.setStore_addr(rs.getString("store_addr"));
						
						list.add(sVo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs);
				}
				return list;
			}

			// Read (select) - 특정 업체 상세 조회
			public StoreVO StoreDetail(String store_name) { 
				String sql_select = "select * from store_info where store_name=?";
				
				
				int result = -1;
				StoreVO sVo = new StoreVO();
				Connection conn = null;
				PreparedStatement pstmt= null;
				ResultSet rs = null;
				
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql_select);
					pstmt.setString(1, store_name);
					rs = pstmt.executeQuery();
					
					//상품 정보 획득
					rs.next();
					sVo.setStore_photo1(rs.getString("store_photo1"));
					sVo.setStore_photo2(rs.getString("store_photo2"));
					sVo.setStore_photo3(rs.getString("store_photo3"));
					sVo.setStore_name(rs.getString("store_name"));
					sVo.setStore_type(rs.getString("store_type"));
					sVo.setStore_time(rs.getString("store_time"));
					sVo.setStore_time_w(rs.getString("store_time_w"));
					sVo.setStore_addr(rs.getString("store_addr"));
					sVo.setStore_addr_detail(rs.getString("store_addr_detail"));
					sVo.setStore_tel(rs.getString("store_tel"));
					sVo.setMenu_info(rs.getString("menu_info"));
					sVo.setParking(rs.getString("parking"));
					sVo.setParking_detail(rs.getString("parking_detail"));
					
				} catch(SQLException e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs);
				}		
				return sVo;
			}
}
		
/*		
		// Read   (select) - 사용자 인증, 데이터 활용
		public int checkUser(String userid, String pwd){
			String sql_insert_pstmt = "select pwd, name from member where userid=?";
			
			int result = -1;
			String name;
			
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			
			
			try {
				// 1. jdbc 드라이버 로드 : forName(className)
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl",
						"ora_user", 
						"1234");
		
				// 3. 쿼리문을 실행하기 위한 객체 생성
				pstmt = conn.prepareStatement(sql_insert_pstmt);
				pstmt.setString(1, userid);
				
				// 4. 쿼리 실행 및 결과 처리
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					if(rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {
						//name = rs.getString("name");
						result = 1; 
					}
				}else {
					//
					result = 0;
					
					result = -1;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try {
				if(rs != null)		rs.close();
				if(pstmt != null)	pstmt.close();
				if (conn != null)	conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}			
			}
			return result; 	
			
		}
		
		public StoreVO getMember(String userid) {
			String sql_select_info = "select * from member where userid=?";
			StoreVO sVo = null;
		
			sVo = new StoreVO(); 
			
			int result = -1;
			String name;
			
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			
			
			try {
				// 1. jdbc 드라이버 로드 : forName(className)
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl",
						"ora_user", 
						"1234");
		
				// 3. 쿼리문을 실행하기 위한 객체 생성
				pstmt = conn.prepareStatement(sql_select_info);
				pstmt.setString(1, userid);
				
				// 4. 쿼리 실행 및 결과 처리
				rs = pstmt.executeQuery();
			
				//
				if(rs.next()) {
					sVo.setName(rs.getString("name"));
					sVo.setUserid(rs.getString("userId"));
					SVo.setPwd(rs.getString("pwd"));
					SVo.setEmail(rs.getString("email"));
					SVo.setPhone(rs.getString("phone"));
					SVo.setAdmin(rs.getInt("admin"));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try {
				if(rs != null)		rs.close();
				if(pstmt != null)	pstmt.close();
				if (conn != null)	conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}			
			}
			return sVo; 	
			
		}
		
		// Update (update) - 회원 정보 수정
		public int updateStoreInfo(StoreVO sVo) {
			String sql_update = "update store_info set pwd=?, email=?, phone=?, admin=? where userid=?";
		
			int result = -1;
			
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			
			
			try {
				// 1. jdbc 드라이버 로드 : forName(className)
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl",
						"ora_user", 
						"1234");
		
				// 3. 쿼리문을 실행하기 위한 객체 생성
				pstmt = conn.prepareStatement(sql_update);
				pstmt.setString(1, sVo.getPwd());
				pstmt.setString(2, sVo.getEmail());
				pstmt.setString(3, sVo.getPhone());
				pstmt.setInt(4, sVo.getAdmin());
				pstmt.setString(5, SVo.getUserid());
				
				// 4. 쿼리 실행 및 결과 처리
				// executeQuery(sql)	- select
				// executeUpdate(sql)	- insert update delete	
				result = pstmt.executeUpdate();
				
				System.out.println(result);
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null)		rs.close();
					if(pstmt != null)	pstmt.close();
					if (conn != null)	conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}			
			}
			
			return result;	
			
			
		}
		
		// Delete (delete) - 회원 삭제
		public int deleteStore(StoreVO sVo) {
			String sql_delete = "delete from store_info where userid=?";
			
			int result = -1;
			
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			
			
			try {
				// 1. jdbc 드라이버 로드 : forName(className)
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl",
						"ora_user", 
						"1234");
		
				// 3. 쿼리문을 실행하기 위한 객체 생성
				pstmt = conn.prepareStatement(sql_delete);
				pstmt.setString(1, sVo.getUserid());
				
				// 4. 쿼리 실행 및 결과 처리
				// executeQuery(sql)	- select
				// executeUpdate(sql)	- insert update delete	
				result = pstmt.executeUpdate();
				
				System.out.println(result);
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null)		rs.close();
					if(pstmt != null)	pstmt.close();
					if (conn != null)	conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}			
			}
			
			return result;
		}
*/		

