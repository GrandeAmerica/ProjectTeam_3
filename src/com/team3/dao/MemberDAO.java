package com.team3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
import com.team3.dto.MemberVO;

import util.DBManager;

public class MemberDAO {
	// 데이터 베이스에 접근하여 데이터를 획득하거나 설정
	// CRUD를 메서드로 구현한 클래스
	
	// 싱글톤 적용
	private MemberDAO() {		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	// Create (insert) - 회원 가입
	public int insertMember(MemberVO mVo) {
		String sql_insert_pstmt = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			// 1. jdbc 드라이버 로드 : forName(className)
			// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
			conn = DBManager.getConnection();
	
			// 3. 쿼리문을 실행하기 위한 객체 생성
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql_insert_pstmt);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getPwd());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getPhone());
			pstmt.setInt(6, mVo.getAdmin());
			
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
	
	
	// Read (select) - 사용자 인증
	// 데이터 베이스에서 회원 정보를 select 하여 값을 비교하고 로그인 수행
	public int checkUser(String userid, String pwd) {		
		String sql_select_pstmt = "select pwd, name from member where userid=?";
		
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();

			// 3. 쿼리문을 실행하기 위한 객체 생성
			pstmt = conn.prepareStatement(sql_select_pstmt);
			pstmt.setString(1, userid);

			// 4. 쿼리 실행 및 결과 처리
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//			System.out.println("pwd : " + rs.getString("pwd"));
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)) {
					result = 1;		// pwd 일치
				} else {
					//암호 불일치
					// 비밀번호가 맞지 않습니다.
					result = 0;
					// 존재하지 않는 회원 입니다.
					result = -1;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return result;
	}
	
	// Read (select) - 데이터 활용
	// userid에 해당하는 회원 정보를 모두 획득
	public MemberVO getMember(String userid) {
		String sql_select_info = "select * from member where userid=?";
		MemberVO mVo = null;		

		mVo = new MemberVO();
		
		int result = -1;
		String name;
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();

			// 3. 쿼리문을 실행하기 위한 객체 생성
			pstmt = conn.prepareStatement(sql_select_info);
			pstmt.setString(1, userid);

			// 4. 쿼리 실행 및 결과 처리
			rs = pstmt.executeQuery();
			
			// 디비로부터 회원 정보 획득
			if(rs.next()) {
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return mVo;
		
	}
	
	// Read (select) - 아이디 중복 확인
	public int confirmID(String userid) {
		String sql_select_checkId ="select userid from member where userid=?";
		
		int result = -1;
	
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();

			// 3. 쿼리문을 실행하기 위한 객체 생성
			pstmt = conn.prepareStatement(sql_select_checkId);
			pstmt.setString(1, userid);

			// 4. 쿼리 실행 및 결과 처리
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//			System.out.println("userid : " + rs.getString("userid"));
				result = 1;
			} else {
				result = -1;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return result;	
		
	}
	
	
	// Update (update) - 회원 정보 수정
	public int updateMember(MemberVO mVo) {
		String sql_update = "update member set pwd=?, email=?, phone=?, admin=? where userid=?";
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			// 1. jdbc 드라이버 로드 : forName(className)
			// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
			conn = DBManager.getConnection();
	
			// 3. 쿼리문을 실행하기 위한 객체 생성
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, mVo.getPwd());
			pstmt.setString(2, mVo.getEmail());
			pstmt.setString(3, mVo.getPhone());
			pstmt.setInt(4, mVo.getAdmin());
			pstmt.setString(5, mVo.getUserid());
			
			// 4. 쿼리 실행 및 결과 처리
			// executeUpdate(sql)	- update	
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
	// Delete (delete) - 회원 삭제
	public int deleteMember() {
		String sql_delete = "delete from member where userid=?";
		
		int result = -1;
		
		return result;		
	}
	
=======
import com.team3.dto.B_userVO;
import com.team3.dto.N_userVO;

import util.DBManager;

public class MemberDAO {

	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	// 데이터 베이스에 접근하여 데이터를 획득하거나 설정

	// Create (insert) - 회원 가입
	public int n_sign_up(N_userVO nVO) {
		String sql = "insert into n_user(user_id,user_password,user_name,user_email,user_tel) VALUES(?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = -1;

		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nVO.getUser_id());
			pstmt.setString(2, nVO.getUser_password());
			pstmt.setString(3, nVO.getUser_name());
			pstmt.setString(4, nVO.getUser_email());
			pstmt.setString(5, nVO.getUser_tel());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int b_sign_up(B_userVO nVO) {
		String sql = "insert into b_user(user_id,user_password,user_name,user_email,user_tel,b_license) VALUES(?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = -1;

		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nVO.getUser_id());
			pstmt.setString(2, nVO.getUser_password());
			pstmt.setString(3, nVO.getUser_name());
			pstmt.setString(4, nVO.getUser_email());
			pstmt.setString(5, nVO.getUser_tel());
			pstmt.setString(6, nVO.getB_license());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	// Read (select) - 사용자 인증,
	public int n_sign_in(String user_id, String user_password) {
		String sql = "select user_id, user_password from n_user where user_id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -1;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("user_password") != null && rs.getString("user_password").equals(user_password)) {

					result = 1;
				} else {

					result = 0;

					result = -1;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public int b_sign_in(String user_id, String user_password) {
		String sql = "select user_id, user_password from b_user where user_id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -1;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("user_password") != null && rs.getString("user_password").equals(user_password)) {

					result = 1;
				} else {

					result = 0;

					result = -1;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 사용자 정보
	public N_userVO n_profile(String user_id) {
		String sql = "select * from n_user where user_id=?";
		N_userVO nvo = new N_userVO();

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				nvo.setUser_id(rs.getString("user_id"));
				nvo.setUser_password(rs.getString("user_password"));
				nvo.setUser_name(rs.getString("user_name"));
				nvo.setUser_email(rs.getString("user_email"));
				nvo.setUser_tel(rs.getString("user_tel"));
				nvo.setN_membership(rs.getInt("n_membership"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nvo;
	}

	public B_userVO b_profile(String user_id) {
		String sql = "select * from b_user where user_id=?";
		B_userVO bvo = new B_userVO();

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bvo.setUser_id(rs.getString("user_id"));
				bvo.setUser_password(rs.getString("user_password"));
				bvo.setUser_name(rs.getString("user_name"));
				bvo.setUser_email(rs.getString("user_email"));
				bvo.setUser_tel(rs.getString("user_tel"));
				bvo.setB_license(rs.getString("b_license"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bvo;
	}

	// 중복 확인
	public int confirmID(String user_id) {
		String sql = "select n_user.user_id,b_user.user_id from n_user full outer join b_user on n_user.user_id=b_user.user_id where n_user.user_id=? or b_user.user_id=?";

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 아이디 찾기
	public N_userVO n_findIdEmail(String user_email) {
		String sql = "select user_id from n_user where user_email=?";

		N_userVO nvo = new N_userVO();

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				nvo.setUser_id(rs.getString("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nvo;
	}

	public B_userVO b_findIdEmail(String user_email) {
		String sql = "select user_id from b_user where user_email=?";

		B_userVO nvo = new B_userVO();

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				nvo.setUser_id(rs.getString("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nvo;
	}

	// Update (update) - 회원 정보 수정
	public int n_profile_update(N_userVO nvo) {
		String sql = "update n_user set user_password=?,user_name=?,user_email=?,user_tel=? where user_id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = -1;

		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getUser_password());
			pstmt.setString(2, nvo.getUser_name());
			pstmt.setString(3, nvo.getUser_email());
			pstmt.setString(4, nvo.getUser_tel());
			pstmt.setString(5, nvo.getUser_id());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;

	}

	public int b_profile_update(B_userVO bvo) {
		String sql = "update b_user set user_password=?,user_name=?,user_email=?,user_tel=? where user_id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = -1;

		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getUser_password());
			pstmt.setString(2, bvo.getUser_name());
			pstmt.setString(3, bvo.getUser_email());
			pstmt.setString(4, bvo.getUser_tel());
			pstmt.setString(5, bvo.getUser_id());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;

	}

	// 비밀번호 수정
	public int n_pwd_update(N_userVO nvo) {
		String sql = "update n_user set user_password=? where user_id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = -1;

		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getUser_password());
			pstmt.setString(2, nvo.getUser_id());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;

	}

	public int b_pwd_update(B_userVO nvo) {
		String sql = "update b_user set user_password=? where user_id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = -1;

		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getUser_password());
			pstmt.setString(2, nvo.getUser_id());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;

	}

	// Delete (delete) - 회원 삭제
	public int n_user_delete(N_userVO nvo) {
		String sql = "delete from n_user where user_id=?";

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getUser_id());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	public int b_user_delete(B_userVO bvo) {
		String sql = "delete from b_user where user_id=?";

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getUser_id());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

>>>>>>> refs/remotes/develop/develop
}
